
package net.mcreator.tloa.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;

public class SheikahPlateWallBlock extends WallBlock {
	public SheikahPlateWallBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.BASALT).strength(4.5f, 10f).requiresCorrectToolForDrops().forceSolidOn());
	}
}
