/*
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 */

package org.miv.graphstream.ui;

import org.miv.graphstream.ui.graphicGraph.stylesheet.Style;

/**
 * Sprite implementation that can be used in the Swing thread.
 * 
 * @author Antoine Dutot
 */
public class DirectSprite implements Sprite
{
// Attributes	

	/**
	 * The sprite (unique) identifier.
	 */
	protected String id;
	
	/**
	 * The remote.
	 */
	protected GraphViewer viewer;
	
// Constructors
	
	/**
	 * New sprite.
	 * @param id The sprite unique identifier.
	 */
	public DirectSprite( String id, GraphViewer viewer )
	{
		this.id = id;
		this.viewer = viewer;
		viewer.addSpriteNoInstance( id );
	}
	
// Access
	
	public String getId()
	{
		return id;
	}
	
	public GraphViewerRemote getViewerRemote()
	{
		return viewer.newViewerRemote();
	}
	
// Commands

	public void attachToNode( String nodeId )
	{
		viewer.attachSpriteToNode( id, nodeId );
	}

	public void attachToEdge( String edgeId )
	{
		viewer.attachSpriteToEdge( id, edgeId );
	}

	public void detach()
	{
		viewer.detachSprite( id );
	}

	public void position( float percent )
	{
		viewer.positionSprite( id, percent );
	}

	public void position( float x, float y, float z, Style.Units units )
	{
		viewer.positionSprite( id, x, y, z, units );
	}

	public void position( float x, float y, float z )
	{
		viewer.positionSprite( id, x, y, z );
	}
	
	public void addAttribute( String attribute, Object ... values )
	{
		Object value;
		
		if( values.length == 0 )
		     value = true;
		else if( values.length == 1 )
		     value = values[0];
		else value = values;
		
		viewer.addSpriteAttribute( id, attribute, value );
	}
	
	public void setAttribute( String attribute, Object ... values )
	{
		addAttribute( attribute, values );
	}
	
	public void changeAttribute( String attribute, Object ... values )
	{
		addAttribute( attribute, values );
	}
	
	public void removeAttribute( String attribute )
	{
		viewer.removeSpriteAttribute( id, attribute );
	}
}