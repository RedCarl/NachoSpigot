//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.server;

import me.elier.nachospigot.config.NachoConfig;

import java.util.List;
import java.util.Random;

public class BlockThin extends Block {
    public static final BlockStateBoolean NORTH = BlockStateBoolean.of("north");
    public static final BlockStateBoolean EAST = BlockStateBoolean.of("east");
    public static final BlockStateBoolean SOUTH = BlockStateBoolean.of("south");
    public static final BlockStateBoolean WEST = BlockStateBoolean.of("west");
    protected static final AxisAlignedBB[] f = new AxisAlignedBB[] { new AxisAlignedBB(0.4375D, 0.0D, 0.4375D, 0.5625D, 1.0D, 0.5625D), new AxisAlignedBB(0.4375D, 0.0D, 0.4375D, 0.5625D, 1.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.4375D, 0.5625D, 1.0D, 0.5625D), new AxisAlignedBB(0.0D, 0.0D, 0.4375D, 0.5625D, 1.0D, 1.0D), new AxisAlignedBB(0.4375D, 0.0D, 0.0D, 0.5625D, 1.0D, 0.5625D), new AxisAlignedBB(0.4375D, 0.0D, 0.0D, 0.5625D, 1.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.5625D, 1.0D, 0.5625D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.5625D, 1.0D, 1.0D), new AxisAlignedBB(0.4375D, 0.0D, 0.4375D, 1.0D, 1.0D, 0.5625D), new AxisAlignedBB(0.4375D, 0.0D, 0.4375D, 1.0D, 1.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.4375D, 1.0D, 1.0D, 0.5625D), new AxisAlignedBB(0.0D, 0.0D, 0.4375D, 1.0D, 1.0D, 1.0D), new AxisAlignedBB(0.4375D, 0.0D, 0.0D, 1.0D, 1.0D, 0.5625D), new AxisAlignedBB(0.4375D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.5625D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D)};// Hyt
    private final boolean a;

    protected BlockThin(Material var1, boolean var2) {
        super(var1);
        this.j(this.blockStateList.getBlockData().set(NORTH, false).set(EAST, false).set(SOUTH, false).set(WEST, false));
        this.a = var2;
        this.a(CreativeModeTab.c);
    }

    public IBlockData updateState(IBlockData iblockdata, IBlockAccess iblockaccess, BlockPosition blockposition) {
        return iblockdata.set(NORTH, this.c(iblockaccess.getType(blockposition.north()).getBlock()))
                .set(SOUTH, this.c(iblockaccess.getType(blockposition.south()).getBlock()))
                .set(WEST, this.c(iblockaccess.getType(blockposition.west()).getBlock()))
                .set(EAST, this.c(iblockaccess.getType(blockposition.east()).getBlock()));
    }

    public Item getDropType(IBlockData var1, Random var2, int var3) {
        return !this.a ? null : super.getDropType(var1, var2, var3);
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public void a(World world, BlockPosition blockposition, IBlockData iblockdata, AxisAlignedBB var4, List<AxisAlignedBB> var5, Entity var6) {
        iblockdata = this.updateState(iblockdata, world, blockposition);

        this.a(BlockThin.f[0]);
        super.a(world, blockposition, iblockdata, var4, var5, var6);

        if (iblockdata.get(BlockThin.NORTH)) {
            this.a(BlockThin.f[a(EnumDirection.NORTH)]);
            super.a(world, blockposition, iblockdata, var4, var5, var6);
        }

        if (iblockdata.get(BlockThin.SOUTH)) {
            this.a(BlockThin.f[a(EnumDirection.SOUTH)]);
            super.a(world, blockposition, iblockdata, var4, var5, var6);
        }

        if (iblockdata.get(BlockThin.EAST)) {
            this.a(BlockThin.f[a(EnumDirection.EAST)]);
            super.a(world, blockposition, iblockdata, var4, var5, var6);
        }

        if (iblockdata.get(BlockThin.WEST)) {
            this.a(BlockThin.f[a(EnumDirection.WEST)]);
            super.a(world, blockposition, iblockdata, var4, var5, var6);
        }
    }

    private static int a(EnumDirection enumdirection) {
        return 1 << enumdirection.b();
    }

    public void j() {
        this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void updateShape(IBlockAccess iblockaccess, BlockPosition blockposition) {
        IBlockData iblockdata = iblockaccess.getType(blockposition);
        iblockdata = updateState(iblockdata, iblockaccess, blockposition);
        this.a(BlockThin.f[x(iblockdata)]);
    }

    private static int x(IBlockData iblockdata) {
        int i = 0;

        if (iblockdata.get(BlockThin.NORTH)) {
            i |= a(EnumDirection.NORTH);
        }

        if (iblockdata.get(BlockThin.EAST)) {
            i |= a(EnumDirection.EAST);
        }

        if (iblockdata.get(BlockThin.SOUTH)) {
            i |= a(EnumDirection.SOUTH);
        }

        if (iblockdata.get(BlockThin.WEST)) {
            i |= a(EnumDirection.WEST);
        }

        return i;
    }

    public final boolean c(Block var1) {
        return var1.o() || var1 == Blocks.GLASS || var1 == Blocks.STAINED_GLASS || var1 == Blocks.STAINED_GLASS_PANE || var1 instanceof BlockThin;
    }

    protected boolean I() {
        return true;
    }

    public int toLegacyData(IBlockData var1) {
        return 0;
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, NORTH, EAST, WEST, SOUTH);
    }
}
