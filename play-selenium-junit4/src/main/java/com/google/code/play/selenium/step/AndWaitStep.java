/*
 * Copyright 2010-2015 Grzegorz Slowikowski
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

//import com.thoughtworks.selenium.SeleniumException;

import com.google.code.play.selenium.Timeout;

public class AndWaitStep
    extends AbstractSeleniumStep
{

    private VoidSeleniumCommand innerCommand;

    private Timeout timeout;

    public AndWaitStep( VoidSeleniumCommand innerCommand, Timeout timeout )
    {
        this.innerCommand = innerCommand;
        this.timeout = timeout;
    }

    protected void doExecute()
        throws Exception
    {
        innerCommand.execute();
//        try
//        {
            innerCommand.commandProcessor.doCommand( "waitForPageToLoad", new String[] { String.valueOf( timeout.get() ) } );
//        }
//        catch ( SeleniumException e )
//        {
//            String message = e.getMessage();
//            Verify.fail( message );
//        }
    }

    public String toString()
    {
        StringBuffer buf = new StringBuffer();
        buf.append( innerCommand.command ).append( "AndWait('" );
        if ( !"".equals( innerCommand.param1 ) )
        {
            buf.append( innerCommand.param1 );
            if ( !"".equals( innerCommand.param2 ) )
            {
                buf.append( "', '" ).append( innerCommand.param2 );
            }
        }
        buf.append( "')" );
        return buf.toString();
    }

}
