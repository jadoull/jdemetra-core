/*
* Copyright 2013 National Bank of Belgium
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

package ec.tss.sa.diagnostics;

import ec.tss.sa.ISaDiagnosticsFactory;
import ec.tstoolkit.algorithm.CompositeResults;
import ec.tstoolkit.algorithm.IDiagnostics;

/**
 *
 * @author Kristof Bayens
 */
public class MDiagnosticsFactory implements ISaDiagnosticsFactory {

    //public static final MDiagnosticsFactory Default = new MDiagnosticsFactory();
    private MDiagnosticsConfiguration config_;

    public MDiagnosticsFactory() {
        config_ = new MDiagnosticsConfiguration();
    }

    public MDiagnosticsFactory(MDiagnosticsConfiguration config) {
        config_ = config;
    }

    public MDiagnosticsConfiguration getConfiguration() {
        return config_;
    }

    @Override
    public void dispose() {
    }

    @Override
    public String getName() {
        return "M-Statistics";
    }

    @Override
    public String getDescription() {
        return "US-Census Bureau M-Statistics";
    }

    @Override
    public boolean isEnabled() {
        return config_.isEnabled();
    }

    @Override
    public void setEnabled(boolean enabled) {
        config_.setEnabled(enabled);
    }

    @Override
    public Object getProperties() {
        return config_.clone();
    }

    @Override
    public void setProperties(Object obj) {
        MDiagnosticsConfiguration config = (MDiagnosticsConfiguration) obj;
        if (config != null) {
            config.check();
            config_ = config.clone();
        }
    }

    @Override
    public IDiagnostics create(CompositeResults rslts) {
         return MDiagnostics.create(config_, rslts);
    }

    @Override
    public Scope getScope() {
        return Scope.Decomposition;
    }

    @Override
    public int getOrder() {
        return 100;
    }
}
