
package net.mcreator.tloa.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;

public class SheikahStoneWallBlock extends WallBlock {
	public SheikahStoneWallBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.BASALT).strength(4.5f, 10f).requiresCorrectToolForDrops().forceSolidOn());
	}
}
