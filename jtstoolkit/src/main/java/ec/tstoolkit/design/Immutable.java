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


package ec.tstoolkit.design;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Identifies immutable objects, whose visible state doesn't change after their
 * creation.
 * 
 * Immutable objects should follow the following conventions: - any object
 * passed as parameters in constructors should be used as is in the object,
 * without making copies of them; users of such objects should be aware of that
 * behavior; if need be, it is their responsibility to make a previous copy of
 * those parameters. - objects returned by immutable objects can be (an usually
 * are) part the internal state of the object; they should not be modified.
 * 
 * @author Jean Palate
 */
@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.SOURCE)
public @interface Immutable {
}
