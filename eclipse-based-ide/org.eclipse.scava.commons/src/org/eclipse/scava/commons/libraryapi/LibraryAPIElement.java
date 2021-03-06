/*********************************************************************
* Copyright (c) 2017 FrontEndART Software Ltd.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
*
* Contributors:
*    Zsolt János Szamosvölgyi
*    Endre Tamás Váradi
*    Gergő Balogh
**********************************************************************/
package org.eclipse.scava.commons.libraryapi;

import org.eclipse.scava.commons.ITypeRepresentedByKind;

/**
 * Provides a representation of an element of a library.
 *
 */
public abstract class LibraryAPIElement implements ITypeRepresentedByKind {
	private final LibraryAPIElementKind kind;
	
	public LibraryAPIElement(LibraryAPIElementKind kind) {
		this.kind = kind;
	}
	
	@Override
	public LibraryAPIElementKind getKind() {
		return kind;
	}
}
