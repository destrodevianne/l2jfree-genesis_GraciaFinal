/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.l2jfree.gameserver.network.client.packets.sendable;

import com.l2jfree.gameserver.gameobjects.L2Player;
import com.l2jfree.gameserver.network.client.L2Client;
import com.l2jfree.gameserver.network.client.packets.L2ServerPacket;
import com.l2jfree.network.ClientProtocolVersion;
import com.l2jfree.network.mmocore.MMOBuffer;

/**
 * @author savormix (generated)
 */
public abstract class PledgeReceiveWarList extends L2ServerPacket
{
	/**
	 * A nicer name for {@link PledgeReceiveWarList}.
	 * 
	 * @author savormix (generated)
	 * @see PledgeReceiveWarList
	 */
	public static final class PledgeWarList extends PledgeReceiveWarList
	{
		/**
		 * Constructs this packet.
		 * 
		 * @see PledgeReceiveWarList#PledgeReceiveWarList()
		 */
		public PledgeWarList()
		{
		}
	}
	
	private static final int[] EXT_OPCODES = { 0x3f, 0x00 };
	
	/** Constructs this packet. */
	public PledgeReceiveWarList()
	{
	}
	
	@Override
	protected int getOpcode()
	{
		return 0xfe;
	}
	
	@Override
	protected int[] getAdditionalOpcodes()
	{
		return EXT_OPCODES;
	}
	
	@Override
	protected void writeImpl(L2Client client, L2Player activeChar, MMOBuffer buf) throws RuntimeException
	{
		// TODO: when implementing, consult an up-to-date packets_game_server.xml and/or savormix
		final boolean god = client.getVersion().isNewerThanOrEqualTo(ClientProtocolVersion.GODDESS_OF_DESTRUCTION);
		buf.writeD(0); // Tab
		if (!god)
			buf.writeD(0); // Page??
		final int sizeA = 0; // Pledge count
		buf.writeD(sizeA);
		for (int i = 0; i < sizeA; i++)
		{
			buf.writeS(""); // Pledge name
			if (god)
			{
				buf.writeD(2); // ??? 2
				buf.writeD(0); // Time in war
				buf.writeD(0); // ??? 2/0
			}
			else
			{
				buf.writeD(0); // Declared??
				buf.writeD(0); // Under attack??
			}
		}
	}
}
