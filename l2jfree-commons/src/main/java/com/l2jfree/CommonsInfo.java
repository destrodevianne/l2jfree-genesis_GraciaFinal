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
package com.l2jfree;

import com.l2jfree.util.jar.FormattedVersion;

/**
 * Generic class to provide version info.
 * 
 * @author noctarius
 */
public class CommonsInfo
{
	protected CommonsInfo()
	{
		// utility class
	}
	
	private static final FormattedVersion COMMONS_VERSION = new FormattedVersion(L2Config.class);
	
	/**
	 * Shows startup and version information.
	 * 
	 * @param version version info
	 */
	public static void showStartupInfo(FormattedVersion version)
	{
		System.out.println("");
		System.out.println("");
		System.out.println(" ___       ___           ___");
		System.out.println("/\\_ \\    /'___`\\   __  /'___\\");
		System.out.println("\\//\\ \\  /\\_\\ /\\ \\ /\\_\\/\\ \\__/  _ __    __     __");
		System.out.println("  \\ \\ \\ \\/_/// /__\\/\\ \\ \\ ,__\\/\\`'__\\/'__`\\ /'__`\\");
		System.out.println("   \\_\\ \\_  // /_\\ \\\\ \\ \\ \\ \\_/\\ \\ \\//\\  __//\\  __/");
		System.out.println("   /\\____\\/\\______/_\\ \\ \\ \\_\\  \\ \\_\\\\ \\____\\ \\____\\");
		System.out.println("   \\/____/\\/_____//\\ \\_\\ \\/_/   \\/_/ \\/____/\\/____/");
		System.out.println("                  \\ \\____/");
		System.out.println("                   \\/___/  [starting version: " + version.getVersionNumber() + "]");
		System.out.println("");
		System.out.println("");
	}
	
	/**
	 * Returns version information string.
	 * 
	 * @return version info
	 */
	public static String[] getFullVersionInfo()
	{
		return new String[] { "l2jfree-commons :    " + COMMONS_VERSION.getFullVersionInfo() };
	}
}
