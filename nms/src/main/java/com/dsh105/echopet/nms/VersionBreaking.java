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

package com.dsh105.echopet.nms;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class VersionBreaking{
	
	public static void setMaxUpStep(Entity entity, float maxStepUp){
		// 1.19.3 and below
		// entity.maxUpStep = maxStepUp;
		// 1.19.4
		// entity.setMaxUpStep(maxStepUp);
		// 1.20.5+
		// idk haha, is this even used wth is the code doing
	}
	
	public static void setFlyingSpeed(LivingEntity entity, float flyingSpeed){
		// 1.19.3 and below
		// entity.flyingSpeed = flyingSpeed;
		// 1.19.4 does it in LivingEntity and doesn't seem to be required by us anymore?
		// 1.20.5+
		// idk haha
	}
	
	public static double getWaterEfficiency(LivingEntity entity){
		// 1.20.6
		// return EnchantmentHelper.getDepthStrider(entity);
		// 1.21+
		return entity.getAttributeValue(Attributes.WATER_MOVEMENT_EFFICIENCY);
	}
}
