package org.eclipse.scava.crossflow.examples.ghmde;


public class RepositoryCounter extends RepositoryCounterBase {
	
	@Override
	public RepositoryResult consumeRepositoryCloneResults(RepositoryClone repositoryClone) throws Exception {
		
		RepositoryResult repositoryResultInst = new RepositoryResult();
		//	repositoryResultInst.setFileCount( String );
		//	repositoryResultInst.setAuthorCount( String );
		//	repositoryResultInst.setTotalCount( String );
		return repositoryResultInst;
	
	}


}
