/*
 * Created by ASEG at Concordia University.
 * http://aseg.cs.concordia.ca
 * http://aseg.cs.concordia.ca/segps
 * Please see the LICENSE file for details.
 */
package ca.concordia.cs.aseg.segps.ontologies.urigenerator.namespace;

public class NamespaceFactory {
	
	 
	public static String createServerLevelNamespace(String nameSpacePrefix,String type)
	{
		String ns=nameSpacePrefix+"/resource/"+type;
		return(ns);
	}
	public static String createProjectLevelNamespace(String nameSpacePrefix,String type,String projectUniqueName)
	{
		String ns=createServerLevelNamespace(nameSpacePrefix,type)+"/"+projectUniqueName;
		return(ns);
	}
	
	public static String createPrgrammingLanguageLevelNamespace(String nameSpacePrefix,String type,String programmingLanguage)
	{
		String ns=createServerLevelNamespace(nameSpacePrefix,type)+"/"+programmingLanguage;
		return(ns);
	}
	
	public static String createFileVariationLevelNamespace(String nameSpacePrefix,String type,String projectUniqueName,String snapshotUniqueName,String homeURLaddress )
	{
		String ns=createSnapshotLevelNamespace(nameSpacePrefix,type,projectUniqueName,snapshotUniqueName)+"/"+homeURLaddress;
		return(ns);
	}
	
	public static String createSnapshotLevelNamespace(String nameSpacePrefix,String type,String projectUniqueName,String snapshotUniqueName)
	{
		String ns=createProjectLevelNamespace(nameSpacePrefix,type,projectUniqueName)+"/"+snapshotUniqueName;
		return(ns);
	}
	public static String createSnapshotLevelNamespace(String nameSpacePrefix,String type,String projectUniqueName,Long snapshotUniqueName)
    {
        String ns=createProjectLevelNamespace(nameSpacePrefix,type,projectUniqueName)+"/"+snapshotUniqueName;
        return(ns);
    }
	public static String createTboxNamespace(String nameSpacePrefix,String tboxName)
	{
		String ns=nameSpacePrefix+"/"+tboxName;
		return(ns);
	}
}
