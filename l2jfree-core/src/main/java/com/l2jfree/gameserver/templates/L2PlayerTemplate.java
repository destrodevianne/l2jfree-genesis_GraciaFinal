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
package com.l2jfree.gameserver.templates;

import com.l2jfree.gameserver.templates.player.ClassId;
import com.l2jfree.gameserver.templates.player.Gender;
import com.l2jfree.gameserver.templates.player.PlayerBaseTemplate;

/**
 * @author NB4L1
 */
public final class L2PlayerTemplate extends L2Template
{
	private final ClassId _classId;
	private final PlayerBaseTemplate[] _playerBaseTemplates;
	
	public L2PlayerTemplate(ClassId classId, PlayerBaseTemplate[] playerBaseTemplates)
	{
		super(-1);
		
		_classId = classId;
		_playerBaseTemplates = playerBaseTemplates;
	}
	
	public ClassId getClassId()
	{
		return _classId;
	}
	
	public PlayerBaseTemplate getPlayerBaseTemplate(Gender gender)
	{
		return _playerBaseTemplates[gender.ordinal()];
	}
}