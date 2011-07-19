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
package com.l2jfree.loginserver.network.legacy.packets.sendable;

import com.l2jfree.loginserver.network.legacy.L2GameServer;
import com.l2jfree.loginserver.network.legacy.packets.L2LoginServerPacket;
import com.l2jfree.network.mmocore.MMOBuffer;

/**
 * @author savormix
 *
 */
public final class KickPlayer extends L2LoginServerPacket
{
	private final String _account;
	
	/**
	 * Constructs a packet to inform about duplicate login.
	 * @param account Account name
	 */
	public KickPlayer(String account)
	{
		_account = account;
	}
	
	/* (non-Javadoc)
	 * @see com.l2jfree.loginserver.network.legacy.packets.L2LoginServerPacket#getOpcode()
	 */
	@Override
	protected int getOpcode()
	{
		return 0x04;
	}
	
	/* (non-Javadoc)
	 * @see com.l2jfree.loginserver.network.legacy.packets.L2LoginServerPacket#writeImpl(com.l2jfree.loginserver.network.legacy.L2GameServer, com.l2jfree.network.mmocore.MMOBuffer)
	 */
	@Override
	protected void writeImpl(L2GameServer client, MMOBuffer buf)
	{
		buf.writeS(_account);
	}
}