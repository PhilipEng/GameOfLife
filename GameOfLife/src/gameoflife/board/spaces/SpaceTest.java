package gameoflife.board.spaces;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpaceTest {

	@Test
	public void test_CreateSpace_TypeCheck() {
		Space space = new Space(18, 1, 0, 5, 10);
		
		assertEquals("Expected space type matches", space.getType(), SpaceType.START_CAREER);
	}
	
	@Test
	public void test_CreateSpaceNoBranch_BranchCheck() {
		Space space = new Space(18, 1, 0, 5, 10);
		
		assertEquals("No branch is created", space.isBranch(), false);
	}
	
	@Test
	public void test_CreateSpaceNoMerge_MergeCheck() {
		Space space = new Space(18, 1, 0, 5, 10);
		
		assertEquals("No merge is created", space.isMerge(), false);
	}
	
	@Test
	public void test_CreateSpaceMerge_MergeCheck() {
		Space space = new Space(18, 1, 4, 5, 10);
		
		assertEquals("Merge is created", space.isMerge(), true);
	}
	
	@Test
	public void test_CreateSpaceMerge_BranchCheck() {
		Space space = new Space(18, 1, 4, 5, 10);
		
		assertEquals("No branch is created", space.isBranch(), false);
	}
	
	@Test
	public void test_CreateSpaceMerge_MergeValueCheck() {
		Space space = new Space(18, 1, 4, 5, 10);
		
		assertEquals("Next space number is to merge space", space.getNextSpaceNum(), 4);
	}
	
	@Test
	public void test_CreateSpaceBranch_BranchCheck() { //Branch is created for STOP_FAMILY and STOP_SCHOOL spaces (12, 13)
		Space space = new Space(18, 12, 4, 5, 10);
		
		assertEquals("Branch is created", space.isBranch(), true);
	}
	
	@Test
	public void test_CreateSpaceBranch_MergeCheck() {
		Space space = new Space(18, 13, 4, 5, 10);
		
		assertEquals("No merge is created", space.isMerge(), false);
	}
	
	@Test
	public void test_CreateSpaceBranch_BranchValueCheck() {
		Space space = new Space(18, 13, 4, 5, 10);
		
		assertEquals("Next space number is to branch space", space.getNextSpaceNum(), 4);
	}

}
