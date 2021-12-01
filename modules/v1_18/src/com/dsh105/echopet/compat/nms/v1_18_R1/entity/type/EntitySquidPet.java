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

package com.dsh105.echopet.compat.nms.v1_18_R1.entity.type;

import com.dsh105.echopet.compat.api.entity.EntityPetType;
import com.dsh105.echopet.compat.api.entity.EntitySize;
import com.dsh105.echopet.compat.api.entity.IPet;
import com.dsh105.echopet.compat.api.entity.PetType;
import com.dsh105.echopet.compat.api.entity.SizeCategory;
import com.dsh105.echopet.compat.api.entity.type.nms.IEntitySquidPet;
import com.dsh105.echopet.compat.nms.v1_18_R1.entity.EntityPet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;

@EntitySize(width = 0.95F, height = 0.95F)
@EntityPetType(petType = PetType.SQUID)
public class EntitySquidPet extends EntityPet implements IEntitySquidPet{
	
	public EntitySquidPet(EntityType<? extends Mob> type, Level world){
		super(type, world);
	}
	
	public EntitySquidPet(EntityType<? extends Mob> type, Level world, IPet pet){
		super(type, world, pet);
	}
	
	public EntitySquidPet(Level world){
		this(EntityType.SQUID, world);
	}
	
	public EntitySquidPet(Level world, IPet pet){
		this(EntityType.SQUID, world, pet);
	}
	
	@Override
	public SizeCategory getSizeCategory(){
		return SizeCategory.REGULAR;
	}
}
