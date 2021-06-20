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

package com.dsh105.echopet.compat.nms.v1_17_R1.entity.type;

import com.dsh105.echopet.compat.api.entity.EntityPetType;
import com.dsh105.echopet.compat.api.entity.EntitySize;
import com.dsh105.echopet.compat.api.entity.IPet;
import com.dsh105.echopet.compat.api.entity.PetType;
import com.dsh105.echopet.compat.api.entity.type.nms.IEntityLlamaPet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import org.bukkit.DyeColor;
import org.bukkit.entity.Llama;

@EntitySize(width = 0.9F, height = 1.87F)
@EntityPetType(petType = PetType.LLAMA)
public class EntityLlamaPet extends EntityHorseChestedAbstractPet implements IEntityLlamaPet{
	
	private static final EntityDataAccessor<Integer> DATA_STRENGTH_ID = SynchedEntityData.defineId(EntityLlamaPet.class, EntityDataSerializers.INT);// changes storage
	private static final EntityDataAccessor<Integer> DATA_SWAG_ID = SynchedEntityData.defineId(EntityLlamaPet.class, EntityDataSerializers.INT);// carpet color
	private static final EntityDataAccessor<Integer> DATA_VARIANT_ID = SynchedEntityData.defineId(EntityLlamaPet.class, EntityDataSerializers.INT);// Like an outfit
	
	public EntityLlamaPet(EntityType<? extends Mob> type, Level world){
		super(type, world);
	}
	
	public EntityLlamaPet(EntityType<? extends Mob> type, Level world, IPet pet){
		super(type, world, pet);
	}
	
	public EntityLlamaPet(Level world){
		this(EntityType.LLAMA, world);
	}
	
	public EntityLlamaPet(Level world, IPet pet){
		this(EntityType.LLAMA, world, pet);
	}
	
	@Override
	protected void defineSynchedData(){
		super.defineSynchedData();
		this.entityData.define(DATA_STRENGTH_ID, 0);
		this.entityData.define(DATA_SWAG_ID, -1);
		this.entityData.define(DATA_VARIANT_ID, 0);
	}
	
	@Override
	public void setCarpetColor(DyeColor color){
		this.entityData.set(DATA_SWAG_ID, color == null ? -1 : color.ordinal());
	}
	
	@Override
	public void setSkinColor(Llama.Color skinColor){
		this.entityData.set(DATA_VARIANT_ID, skinColor.ordinal());
	}
}
