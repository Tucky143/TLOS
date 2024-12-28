package net.mcreator.tloa.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.tloa.network.TloaModVariables;
import net.mcreator.tloa.TloaMod;

public class CryonisAbilityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double CX = 0;
		double CY = 0;
		double CZ = 0;
		if (entity.getData(TloaModVariables.PLAYER_VARIABLES).cryonis_activated) {
			if (entity.isInWall()) {
				TloaMod.LOGGER.info("Failed");
			} else {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WATER && (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == Blocks.WATER
						&& (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == Blocks.WATER && (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == Blocks.WATER
						&& (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == Blocks.WATER && (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.WATER
						&& (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.WATER && (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.WATER
						&& (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.WATER && (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 1))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 1))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 1))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 1))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 2, z - 1))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x - 1, y + 2, z + 1))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 2, z + 1))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x - 1, y + 2, z - 1))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x, y + 2, z + 1))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x, y + 2, z - 1))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x, y + 3, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x + 1, y + 3, z - 1))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 1, y + 3, z + 1))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x + 1, y + 3, z + 1))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 1, y + 3, z - 1))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x, y + 3, z + 1))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x, y + 3, z - 1))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x + 1, y + 3, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 1, y + 3, z))).getBlock() == Blocks.AIR) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("tloa", "cryonis"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 1, y + 1, z - 1), BlockPos.containing(x - 1, y + 1, z - 1),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
					CX = x;
					CY = y + 1;
					CZ = z;
					{
						Entity _ent = entity;
						_ent.teleportTo(x, (y + 4.2), z);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(x, (y + 4.2), z, _ent.getYRot(), _ent.getXRot());
					}
					entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() * 4), (entity.getDeltaMovement().z())));
					entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() * 4), (entity.getDeltaMovement().z())));
					TloaMod.queueServerWork(8, () -> {
						entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() * 4), (entity.getDeltaMovement().z())));
					});
					TloaMod.queueServerWork(200, () -> {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("tloa", "cryonis_empty"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x - 1, y + 1, z - 1), BlockPos.containing(x - 1, y + 1, z - 1),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					});
				} else {
					if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WATER && (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == Blocks.WATER
							&& (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == Blocks.WATER && (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == Blocks.WATER
							&& (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == Blocks.WATER && (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.WATER
							&& (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.WATER && (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.WATER
							&& (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.WATER && (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.WATER
							&& (world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 1))).getBlock() == Blocks.WATER && (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 1))).getBlock() == Blocks.WATER
							&& (world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 1))).getBlock() == Blocks.WATER && (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 1))).getBlock() == Blocks.WATER
							&& (world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock() == Blocks.WATER && (world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock() == Blocks.WATER
							&& (world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == Blocks.WATER && (world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == Blocks.WATER
							&& (world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 2, z - 1))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x - 1, y + 2, z + 1))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 2, z + 1))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x - 1, y + 2, z - 1))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x, y + 2, z + 1))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x, y + 2, z - 1))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x, y + 4, z))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x + 1, y + 4, z - 1))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 1, y + 4, z + 1))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x + 1, y + 4, z + 1))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 1, y + 4, z - 1))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x, y + 4, z + 1))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x, y + 4, z - 1))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x + 1, y + 4, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 1, y + 4, z))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x, y + 3, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 3, z - 1))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x - 1, y + 3, z + 1))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 3, z + 1))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x - 1, y + 3, z - 1))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x, y + 3, z + 1))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x, y + 3, z - 1))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 3, z))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x - 1, y + 3, z))).getBlock() == Blocks.AIR) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("tloa", "cryonis"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x - 1, y + 2, z - 1), BlockPos.containing(x - 1, y + 2, z - 1),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
						CX = x;
						CY = y + 2;
						CZ = z;
						{
							Entity _ent = entity;
							_ent.teleportTo(x, (y + 6.2), z);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(x, (y + 6.2), z, _ent.getYRot(), _ent.getXRot());
						}
						entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() * 4), (entity.getDeltaMovement().z())));
						entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() * 4), (entity.getDeltaMovement().z())));
						TloaMod.queueServerWork(8, () -> {
							entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() * 4), (entity.getDeltaMovement().z())));
						});
						TloaMod.queueServerWork(200, () -> {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("tloa", "cryonis_empty"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x - 1, y + 2, z - 1), BlockPos.containing(x - 1, y + 2, z - 1),
											new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						});
					}
				}
			}
		}
	}
}
