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
package com.l2jfree.loginserver;

import com.l2jfree.loginserver.Config.DatabaseConfig;
import com.l2jfree.sql.DataSourceInitializer;

/**
 * @author savormix
 */
public final class L2LoginDataSource extends DataSourceInitializer
{
	private static final int DB_MIN_CONNECTIONS = 2;
	
	@Override
	protected String getJdbcUrl()
	{
		return DatabaseConfig.DB_URL;
	}
	
	@Override
	protected String getUser()
	{
		return DatabaseConfig.DB_USER;
	}
	
	@Override
	protected String getPassword()
	{
		return DatabaseConfig.DB_PASSWORD;
	}
	
	@Override
	protected int getMinConnections()
	{
		return DB_MIN_CONNECTIONS;
	}
	
	@Override
	protected int getMaxConnections()
	{
		return DatabaseConfig.DB_MAX_CONNECTIONS;
	}
}
