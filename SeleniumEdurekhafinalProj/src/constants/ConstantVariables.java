package constants;

import utilities.ExcelReadWrite;

public class ConstantVariables {

	public final static String User = "WP_User";
	public final static String Password = "WP_Pass";
	public static String Loginbtn = "WP_Loginbtn";
	public static String URL = "http://demo.opensourcecms.com/wordpress/wp-login.php";
	public static String LostPasswordlnk = "WP_LostPasswordlnk";
	public static String LogInlnk = "WP_LogInlnk"
			;
	//public static String Login_Click = "landing_Login";
	
	public static String DBPostslnk = "DB_Postslnk";
	public static String DBAddNewPostlnk = "DB_AddNewPostlnk";
	public static String DBTitleXP = "DB_TitleXP";
	
	public static String DBBodyXP = "DB_BodyXP";
	public static String DBBodyContentXP = "DB_BodyContentXP";
	public static String DBPreviewbtn = "DB_Previewbtn";
	public static String DBAddTagVal = "DB_AddTagVal";
	public static String DBAddbtn = "DB_Addbtn";
	
	public static String DBScreenOptionslnk="DB_ScreenOptionslnk";
	public static String DBSettingsId = "DB_SettingsId";
	public static String DB_CHKBOXDSlugXP = "DB_CHKBOXDSlugXP";
	
	public static String DBAdminBarId = "DB_AdminBarId";
	public static String DBAdminBarlnk = "DB_AdminBarlnk";
	public static String DBLogoutlnk = "DB_Logoutlnk";
	public static String expectedColor;
	public static String expectedError = "";
	
	//public static String shtName="sheet1";

	public static final String shtName = "TestData";
	public static final String pathName = "C:\\Users\\t15clsp\\SeleniumEdurekha1\\Linkedin_Hybrid\\src\\constants\\TestData.xlsx";
	public static final String Logintitle = "";
	
	public static String propertyFileLocation = "C:\\Users\\t15clsp\\workspaceEdurekha\\SeleniumEdurekhafinalProj\\Locators.properties";
	
	public static String fstName = ExcelReadWrite.getSheetData(shtName, 1, 1);
	public static String LstName = ExcelReadWrite.getSheetData(shtName, 1, 2);
			
	
	
}
