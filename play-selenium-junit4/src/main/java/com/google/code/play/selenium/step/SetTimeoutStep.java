/*
 * Copyright 2010-2014 Grzegorz Slowikowski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.code.play.selenium.step;

import com.google.code.play.selenium.Timeout;

public class SetTimeoutStep
    extends CommandStep
{

    private Timeout timeout;
                    
    public SetTimeoutStep( VoidSeleniumCommand innerStoreCommand, Timeout timeout )
    {
        super( innerStoreCommand );
        this.timeout = timeout;
    }

    public void doExecute()
        throws Exception
    {
        super.doExecute();
        String millisStr = command.storedVars.fillValues( command.param1 );
        if ( "".equals( millisStr ) )
        {
            timeout.reset();
        }
        else
        {
            int millis = Integer.parseInt( millisStr );
            timeout.set( millis ); // TODO-validate
        }
    }

}
