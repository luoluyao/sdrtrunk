/*******************************************************************************
 *     SDR Trunk 
 *     Copyright (C) 2014 Dennis Sheirer
 * 
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 * 
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>
 ******************************************************************************/
package decode.tait;

import alias.Alias;
import alias.AliasList;
import controller.activity.CallEvent;
import decode.DecoderType;

public class Tait1200CallEvent extends CallEvent
{
    public Tait1200CallEvent( CallEventType callEventType,
    						AliasList aliasList, 
    						String fromID, 
    						String toID, 
    						String details ) 
    {
        super( DecoderType.TAIT_1200, callEventType, 
        		aliasList, fromID, toID, details );
    }

    private Alias getAlias( String ident )
    {
        if( hasAliasList() )
        {
        	return getAliasList().getFleetsyncAlias( ident );
        }
        
        return null;
    }
    
    @Override
    public Alias getFromIDAlias()
    {
        return getAlias( getFromID() );
    }

    @Override
    public Alias getToIDAlias()
    {
        return getAlias( getToID() );
    }

    @Override
    public String getChannel()
    {
        return null;
    }

    @Override
    public long getFrequency()
    {
        return 0;
    }

    public static class Builder
    {
        /* Required parameters */
        private CallEventType mCallEventType;

        /* Optional parameters */
        private AliasList mAliasList;
        private String mFromID;
        private String mToID;
        private String mDetails;

        public Builder( CallEventType callEventType )
        {
            mCallEventType = callEventType;
        }
        
        public Builder aliasList( AliasList aliasList )
        {
            mAliasList = aliasList;
            return this;
        }
        
        public Builder from( String val )
        {
            mFromID = val;
            return this;
}

        public Builder details( String details )
        {
            mDetails = details;
            return this;
        }
        
        public Builder to( String toID )
        {
            mToID = toID;
            return this;
        }

        public Tait1200CallEvent build()
        {
            return new Tait1200CallEvent( this );
        }
    }

    /**
     * Private constructor for the builder
     */
    private Tait1200CallEvent( Builder builder )
    {
        this( builder.mCallEventType,
              builder.mAliasList, 
              builder.mFromID,
              builder.mToID,
              builder.mDetails );
    }
    
    public static Tait1200CallEvent getLJ1200Event( Tait1200GPSMessage message )
    {
        CallEventType type = CallEventType.COMMAND;
        
        return new Tait1200CallEvent.Builder( type )
        						.details( message.getMessage() )
        						.build();
    }
}
