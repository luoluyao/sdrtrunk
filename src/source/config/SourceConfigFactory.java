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
package source.config;

import source.SourceType;

public class SourceConfigFactory
{
	public static SourceConfiguration getDefaultSourceConfiguration()
	{
		return getSourceConfiguration( SourceType.NONE );
	}
	
	public static SourceConfiguration 
		getSourceConfiguration( SourceType source )
	{
		SourceConfiguration retVal;

		switch( source )
		{
			case MIXER:
				retVal = new SourceConfigMixer();
				break;
			case TUNER:
				retVal = new SourceConfigTuner();
				break;
			case RECORDING:
				retVal = new SourceConfigRecording();
				break;
			case NONE:
			default:
				retVal = new SourceConfigNone();
				break;
		}
		
		return retVal;
	}
}
