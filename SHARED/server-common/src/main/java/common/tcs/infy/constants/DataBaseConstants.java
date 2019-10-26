package common.tcs.infy.constants;

public class DataBaseConstants {
	
	
	private DataBaseConstants() {
		throw new IllegalStateException("Utility class");
	}

	
	/*
	  COMMON COLUMN constants 
	 */
	public static final String CREATED_BY = "Createdby";
	public static final String CREATED_ON = "Createdon";
	public static final String UPDATED_BY = "Updatedby";
	public static final String UPDATED_ON = "Updatedon";
	public static final String PRIMARY_KEY_ID = "ID";
	public static final String PRIMARY_KEY_Id = "Id";
	public static final String NAME = "Name";
	public static final String IS_PUSH_NOTIFICATION = "Ispushnotification";
	public static final String IS_SMS = "Issms";
	public static final String COMPANY_ID = "company_ID";
	public static final String STATUS = "Status";
	public static final String VEHICLE_NUMBER = "Vehiclenumber";
	public static final String MOBILE_NUMBER = "Mobile";
	public static final String IS_CHARGE = "Ischarge";
	public static final String IS_IGNITION = "Isignition";
	
	/*
	  ALERT_SETTING Table 
	 */
	public static final String ALERT_SETTING_TABLE = "tbl_alertsetting";
	public static final String IS_NAME = "Isemail";
	
	
	
	
	/*
	  BLACK_BOX Table 
	 */
	public static final String BLACK_BOX_TABLE = "tbl_blackbox";
	public static final String VEHICLE_POINT = "vehiclePoint";
	public static final String IS_INSERT = "Isinsert";
	
	/*
	  COMPANY Table 
	 */
	public static final String COMPANY_TABLE = "tbl_company";
	public static final String EMAIL_ID = "email";
	public static final String ADDRESS_LINE1 = "address1";
	public static final String ADDRESS_LINE2 = "address2";
	public static final String CITY = "city";
	public static final String PIN_CODE = "pincode";
	public static final String PHONE_NUMBER_NUMERICAL = "phone1";
	public static final String MOBILE = "mobile";
	public static final String SMS_NOTIFICATION = "smsnotification";
	public static final String EMAIL_NOTIFICATION = "emailnotification";
	public static final String SPEED_LIMIT = "speedlmt";
	public static final String OVER_SPEED_LIMIT = "overspeedlmt";
	public static final String IDL_DURATION = "idlduration";
	public static final String HALT_DURATION = "haltduration";
	public static final String IS_EMAIL = "isemail";
	
	
	/*
	  ERROR_CATCH Table 
	 */
	public static final String ERROR_CATCH_TABLE = "tbl_errorcatch";
	public static final String APPLICATION_TYPE = "Apptype";
	public static final String FORM_NAME = "Formname";
	public static final String DESCRIPTION = "Description";
	public static final String APPLICATION_VERSION = "Appversion";
	
	/*
	  MOBILE_APPLICATION_TABLE Table 
	 */
	public static final String MOBILE_APPLICATION_TABLE = "tbl_mobileapp";
	public static final String KEY_ID = "Keyid";
	public static final String IMEI_NUMBER = "Imeino";
	public static final String ACTIVE = "Active";
	
	
	/*
	  NOTIFICATION_LOG Table 
	 */
	public static final String NOTIFICATION_LOG_TABLE = "tbl_notificationlog";
	public static final String MESSAGE_DT = "Messagedt";
	public static final String MESSAGE_TYPE = "Messagetype";
	public static final String TITLE = "Title";
	public static final String MESSAGE = "Message";
	
	/*
	  TRACK_MATE_TABLE Table 
	 */
	public static final String TRACK_MATE_TABLE = "tbl_trackmate";
	
	
	/*
	  USER_TABLE Table 
	 */
	public static final String USER_TABLE = "tbl_user";
	public static final String LAST_NAME = "Lname";
	public static final String EMAIL_ADDRESS = "Emailid";
	public static final String PHONE_NUMBER = "Phone";
	public static final String ROLE = "Role";
	public static final String PASSWORD = "Password";
	
	
	/*
	  VEHICLE_TABLE Table 
	 */
	
	public static final String VEHICLE_TABLE = "tbl_vehicle";
	public static final String VEHICLE_TYPE = "Vehicletype";
	public static final String ENGINE_NUMBER = "Engnumber";
	public static final String DRIVER_NAME = "Drivername";
	public static final String DISPLAY_VEHICLE_NUMBER = "Disvehiclenumber";
	public static final String IMEI_NUMBER_CAPITAL = "IMEI";
	public static final String VALID_UPTO = "Validupto";
	public static final String PLAN = "Plan";
	public static final String DEVICE = "Device";
	public static final String DEVICE_COMPANY = "Devicecompany";
	public static final String LONGITUDE = "Lon";
	public static final String LATITUDE = "Lat";
	public static final String DATE_COLUMN = "Dt";
	public static final String SPEED = "Speed";
	public static final String DIRECTION = "Direction";

	
	
	/*
	  VEHICLE_POINT_TABLE Table 
	 */
	
	public static final String VEHICLE_POINT_TABLE = "tbl_vehicle_point";
	public static final String END_DATE = "Enddt";
	public static final String VEHICLE_BATTERY = "Vehbat";
	public static final String DIRECTIONS = "Dirct";
	public static final String INTERNAL_BATTERY = "Interbat";
	public static final String IGNITION = "Ignition";
	public static final String TAMPER = "Tamper";
	public static final String GPS_STATUS = "Gpsstatus";
	public static final String ADDRESS = "address";
	public static final String DISTANCE = "Distance";
	public static final String IS_GPS = "Isgps";
	public static final String IS_OIL_DISCONNCETED = "Isoildisconnected";
	public static final String SEQUENCE_NUMBER = "Sequenceno";
	public static final String SEQUENCE_NUMBER_HEXA_DECIMAL = "Sequencenohex";
	
	
	
	
	

}
