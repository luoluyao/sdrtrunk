package decode.p25.message.tsbk.motorola;

import alias.AliasList;
import bits.BinaryMessage;
import decode.p25.reference.DataUnitID;

public class PatchGroupDelete extends PatchGroup
{
	public PatchGroupDelete( BinaryMessage message, DataUnitID duid,
            AliasList aliasList )
    {
	    super( message, duid, aliasList );
    }

	@Override
    public String getEventType()
    {
	    return MotorolaOpcode.PATCH_GROUP_DELETE.getLabel();
    }
}	
