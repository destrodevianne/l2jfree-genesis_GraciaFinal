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
package com.l2jfree.gameserver.network.client.packets.receivable;

import java.nio.BufferUnderflowException;

import com.l2jfree.gameserver.network.client.packets.L2ClientPacket;
import com.l2jfree.network.mmocore.InvalidPacketException;
import com.l2jfree.network.mmocore.MMOBuffer;

/**
 * @author savormix (generated)
 */
public abstract class RequestSendPost extends L2ClientPacket
{
	/**
	 * A nicer name for {@link RequestSendPost}.
	 * 
	 * @author savormix (generated)
	 * @see RequestSendPost
	 */
	public static final class RequestSendMail extends RequestSendPost
	{
		/**
		 * Constructs this packet.
		 * 
		 * @see RequestSendPost#RequestSendPost()
		 */
		public RequestSendMail()
		{
		}
	}
	
	/** Packet's identifier */
	public static final int OPCODE = 0xd0;
	/** Additional packet's identifiers */
	public static final int[] EXT_OPCODES = { 0x66, 0x00 };
	/** Packet's second identifier */
	public static final int OPCODE_2 = 0x66;
	
	/** Constructs this packet. */
	public RequestSendPost()
	{
	}
	
	@Override
	protected int getMinimumLength()
	{
		return READ_S + READ_D + READ_S + READ_S + READ_D;
	}
	
	@Override
	protected void read(MMOBuffer buf) throws BufferUnderflowException, RuntimeException
	{
		// TODO: when implementing, consult an up-to-date packets_game_server.xml and/or savormix
		buf.readS(); // Recipient
		buf.readD(); // COD
		buf.readS(); // Subject
		buf.readS(); // Message
		final int sizeA = buf.readD(); // Attachment count
		for (int i = 0; i < sizeA; i++)
		{
			buf.readD(); // Item OID
			buf.readQ(); // Quantity
		}
	}
	
	@Override
	protected void runImpl() throws InvalidPacketException, RuntimeException
	{
		// TODO: implement
	}
}