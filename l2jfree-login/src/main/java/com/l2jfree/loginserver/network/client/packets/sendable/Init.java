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
package com.l2jfree.loginserver.network.client.packets.sendable;

import com.l2jfree.loginserver.network.client.L2Client;
import com.l2jfree.loginserver.network.client.L2ClientSecurity;
import com.l2jfree.loginserver.network.client.packets.L2ServerPacket;
import com.l2jfree.loginserver.network.client.packets.receivable.AuthGameGuard;
import com.l2jfree.network.mmocore.MMOBuffer;
import com.l2jfree.security.NewCipher;

/**
 * This packet is sent by the login server immediately after a connection is established. The client
 * then replies with {@link AuthGameGuard}.
 * 
 * @author savormix
 */
public final class Init extends L2ServerPacket
{
	private final int _sessionId;
	private final int _protocol;
	private final byte[] _publicKey;
	private final byte[] _blowfishKey;
	private final NewCipher _cipher;
	
	/**
	 * Creates a packet to inform about security parameters used in further communications.
	 * 
	 * @param client a connection wrapper with assigned parameters
	 */
	public Init(L2Client client)
	{
		_sessionId = client.getSessionId();
		_protocol = client.getProtocol();
		_publicKey = client.getPublicKey();
		_cipher = new NewCipher(L2ClientSecurity.getInstance().getBlowfishKey());
		_blowfishKey = _cipher.getBlowfishKey();
	}
	
	@Override
	protected int getOpcode()
	{
		return 0x00;
	}
	
	@Override
	protected void writeImpl(L2Client client, MMOBuffer buf)
	{
		buf.writeD(_sessionId);
		buf.writeD(_protocol);
		buf.writeB(_publicKey);
		
		//buf.writeQ(Rnd.get(Long.MIN_VALUE, Long.MAX_VALUE));
		//buf.writeQ(Rnd.get(Long.MIN_VALUE, Long.MAX_VALUE));
		buf.write0(16);
		
		buf.writeB(_blowfishKey);
		buf.writeC(0x00); // C string termination
	}
	
	@Override
	protected void packetWritten(L2Client client) throws RuntimeException
	{
		client.setCipher(_cipher);
	}
}
