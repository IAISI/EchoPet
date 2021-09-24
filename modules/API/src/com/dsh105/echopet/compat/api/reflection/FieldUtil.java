/*
 * This file is part of EchoPet.
 *
 * EchoPet is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * EchoPet is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with EchoPet. If not, see <http://www.gnu.org/licenses/>.
 */

package com.dsh105.echopet.compat.api.reflection;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

public class FieldUtil{
	
	private static Unsafe unsafe;
	
	static{
		try{
			final Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
			unsafeField.setAccessible(true);
			unsafe = (Unsafe) unsafeField.get(null);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void setFinalStatic(Field field, Object value) throws Exception{
		Object fieldBase = unsafe.staticFieldBase(field);
		long fieldOffset = unsafe.staticFieldOffset(field);
		
		unsafe.putObject(fieldBase, fieldOffset, value);
	}
	
	public static void setFinalField(Object object, Field field, Object value) throws Exception{
		long fieldOffset = unsafe.objectFieldOffset(field);
		
		unsafe.putObject(object, fieldOffset, value);
	}
	
	public static <T> T getField(Class<?> clazz, String fieldName){
		try{
			Field field = clazz.getDeclaredField(fieldName);
			field.setAccessible(true);
			return (T) field.get(null);
		}catch(Exception ex){
			return null;
		}
	}
}