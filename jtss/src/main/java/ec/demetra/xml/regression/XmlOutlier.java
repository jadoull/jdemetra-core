/*
 * Copyright 2016 National Bank of Belgium
 * 
 * Licensed under the EUPL, Version 1.1 or – as soon they will be approved 
 * by the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 * 
 * http://ec.europa.eu/idabc/eupl
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and 
 * limitations under the Licence.
 */
package ec.demetra.xml.regression;

import ec.tss.xml.XmlDayAdapter;
import ec.tstoolkit.timeseries.Day;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Jean Palate
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutlierType", propOrder = {
    "position"
})
public abstract class XmlOutlier extends XmlRegressionVariable {

    @XmlElement(name = "Position", required = true)
    @XmlJavaTypeAdapter(XmlDayAdapter.class)
    protected Day position;

    @XmlAttribute(name = "preSpecified")
    protected Boolean preSpecified;

    /**
     * @return the position
     */
    public Day getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Day position) {
        this.position = position;
    }

    public boolean isPreSpecified() {
        if (preSpecified == null) {
            return false;
        } else {
            return preSpecified;
        }
    }

    /**
     * @param preSpecified the preSpecified to set
     */
    public void setPreSpecified(Boolean preSpecified) {
        this.preSpecified = preSpecified;
    }
}
