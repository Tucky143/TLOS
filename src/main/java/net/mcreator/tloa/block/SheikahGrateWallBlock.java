
package net.mcreator.tloa.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class SheikahGrateWallBlock extends WallBlock {
	public SheikahGrateWallBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.BASALT).strength(4.2f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false).forceSolidOn());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 3;
	}
}
