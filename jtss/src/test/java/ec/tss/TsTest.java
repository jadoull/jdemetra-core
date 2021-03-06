/*
 * Copyright 2013 National Bank of Belgium
 *
 * Licensed under the EUPL, Version 1.1 or – as soon they
 will be approved by the European Commission - subsequent
 versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the
 Licence.
 * You may obtain a copy of the Licence at:
 *
 * http://ec.europa.eu/idabc/eupl
 *
 * Unless required by applicable law or agreed to in
 writing, software distributed under the Licence is
 distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 express or implied.
 * See the Licence for the specific language governing
 permissions and limitations under the Licence.
 */
package ec.tss;

import data.Data;
import ec.tstoolkit.MetaData;
import ec.tstoolkit.timeseries.simplets.TsData;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jean Palate
 */
public class TsTest {
    
    public TsTest() {
    }

    @Test
    public void testSelection() {
        Ts s=TsFactory.instance.createTs("test", new MetaData(), Data.P);
        s.getMetaData().put(Ts.BEG, Data.P.getStart().firstday().toString());
        s.getMetaData().put(Ts.END, Data.P.getLastPeriod().minus(12).lastday().toString());
        s.getMetaData().put(Ts.CONFIDENTIAL, Data.P.getEnd().minus(24).firstday().toString());
        
        TsData d=s.getTsData();
        TsData b=d.select(s.getSelector(Ts.DataFeature.Backcasts));
        TsData f=d.select(s.getSelector(Ts.DataFeature.Forecasts));
        TsData a=d.select(s.getSelector(Ts.DataFeature.Actual));
        TsData p=d.select(s.getSelector(Ts.DataFeature.Public));
        TsData c=d.select(s.getSelector(Ts.DataFeature.Confidential));
        
        assertTrue(b.getLength()+a.getLength()+f.getLength() == d.getLength());
        assertTrue(p.getLength()+c.getLength() == d.getLength());
        assertTrue(b.getLength()==0);
        assertTrue(f.getLength()==12);
        assertTrue(c.getLength()==24);
    }
}