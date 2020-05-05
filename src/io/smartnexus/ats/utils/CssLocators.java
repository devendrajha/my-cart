package io.smartnexus.ats.utils;

public class CssLocators {

  // Login Page
  public static final String loginLinkKey = "a#btnLoginWithOkta";
  public static final String keyClockLinkKey = "a#btnLoginWithLKeycloak";
  public static final String azureLoginLinkKey = "a#btnLoginWithAzure";
  public static final String loginuserNameFieldKey = "input[name=\"username\"]";
  public static final String passwordKey = "input[name=\"password\"]";
  public static final String signinButtonKey = "input[type=\"submit\"]";
  public static final String signinCompanySelectKey = "select#ddlCompanyList";
  public static final String submitCompanyButtonKey = "#btnSubmit";
  public static final String sideNavigationOptionKey = "a.dropbtn";
  public static final String logOutLinkKey = "a[href='https://dev-2.portal.us.flex-ci.com/Account/LogoutUser']";
  public static final String loginFailedMsg = "div#signin-feedback";
  public static final String loginFailedMessage = "div.okta-form-infobox-error p";
  public static final String loginFailMessageAzure = "div#cta_error_message_text h1";
  public static final String needHelpLink = "a[data-se=\"needhelp\"]";
  public static final String forgotPasswordLink = "a[data-se=\"forgot-password\"]";
  public static final String forgotPasswordLinkAzure = "a#cred_forgot_password_link";
  public static final String flexHeader = "h1#login_workload_logo_text";
  public static final String homePageFlexLogoKey = "div#flex-logo";
  public static final String changeCompanyKey = "#lnkChangeCompany";
  public static final String changeCompanySelectKey = "#ddlCompanyList";
  public static final String getLoginErrorForPassword = "p.o-form-input-error";
  public static final String getDisplayedUserNameWelcomeMessage = "div#divUserInformation";

  // Azure Login page

  public static final String inputUserIdKey = "input#cred_userid_inputtext";
  public static final String useAnotherAccountKey = "a#use_another_account_link";
  public static final String inputPasswordKey = "input#cred_password_inputtext";
  public static final String signInButtonKey = "button#cred_sign_in_button";
  public static final String inputUsernameFieldKey = "input#ctl00_ContentPlaceHolder1_UsernameTextBox";
  public static final String inputPasswordFieldKey = "input#ctl00_ContentPlaceHolder1_PasswordTextBox";
  public static final String loginButtonKey = "input#ctl00_ContentPlaceHolder1_SubmitButton";

  // forget password page
  public static final String forgrtPasswordAzureEmailKey = "input[title=\"Enter your email address\"]";
  public static final String forgotPasswordCancel = "a#ContentPlaceholderMainContent_ButtonCancel";
  public static final String forgotPasswordEmailKey = "input[placeholder=\"Email or Username\"]";
  public static final String forgotPasswordSendEmailButtonKey = "input[value=\"Reset via Email\"]";
  public static final String emailSentContainerKey = "div.password-reset-email-sent";

  // Add Product line
  public static final String productLineSearchboxKey = "input#txtSearchItemList";
  public static final String productSearchboxKey = "input#txtContainerSearch";
  public static final String addProductLineLinkKey = "button#btnHeaderAdd > span";
  public static final String productSearchGoButtonKey = "button#btnSearchGo";
  public static final String editProductLineButtonKey = "button#btnHeaderEdit";
  public static final String addProductLineNameFieldKey = "input#txtProductlineName";
  public static final String addProductLineSkuFieldKey = "input#txtProductlineSku";
  public static final String addProductLineDescriptionFieldKey = "input#txtProductlineDescription";
  public static final String addProductLineSaveButtonKey = "button#btnSave";
  public static final String updateProductLineButtonKey = "button#btnUpdate";
  public static final String searchProductLineResultKey = "ul#list-group > li> a#lnkDetailsPage";
  public static final String searchProductDeviceIDResultKey = "div#divProductTab>table#tblProduct>tbody>tr>td:nth-child(3)";
  public static final String searchProductStatusResultKey = "div#product-grid-data-row > div#product-grid-data-row-static-endpoint-status-container > p#product-grid-data-row-static-endpoint-status";
  public static final String errorMsgDuplicateProductLineKey = "div#error-message-container";
  public static final String deletePopUp = "div.modal-content h3";
  public static final String searchVirtualProductNameResultKey = "p#virtual-product-grid-data-name";
  public static final String searchUserFieldNameResultKey = "div#divUserFieldsTab>table#tblUserFields>tbody>tr>td:nth-child(1)";
  public static final String virtualProductLinkKey = "div#tab-header-product-list-virtual-products-container > h6";
  public static final String messageDisplayed = "span.toast-message";
  public static final String pageCount = "div#product-grid-data-pager-page-count";

  // Delete Product line
  public static final String deleteProductLineButtonKey = "button#btnHeaderDelete";
  public static final String deleteConfirmationNotificationKey = "button#btnDelete";
  public static final String errorOkButtonKey = "button#error-popup-ok";
  // Add Product
  public static final String addProductButtonKey = "button#btnAddProductTab";
  public static final String fileInputStringKey = "div#divFileUpload input";
  public static final String fileUploadSubmitButtonKey = "button#btnSubmit";
  public static final String fileUploadConfirmButtonKey = "button#btnConfirm";
  public static final String fileUploadOkButtonKey = "button#success-popup-ok";
  public static final String productStatusContainerKey = "div#divSummaryTab >div >div>span";
  public static final String pickFirstProductFromTheList = "button#product-grid-data-row-static-endpoint-details-link";
  public static final String getAlertMezssage = "div#alert-message";
  public static final String clickNextButton = "li.pagination-next a";
  public static final String settingIconroductLineKey = "a#lnkSettings > span";
  public static final String addUserFieldsSettingButton = "button#btnAddProductlineUserField";
  public static final String editSettingUserfields = "a#lnkEditUserfield";
  public static final String deleteSettingUserFields = "div[data-order=\"1\"] +div+div > a.delete-userfield-link";
  public static final String deleteSettingUserFields1 = "a#delete-userfield-link modal-content-prompt-delete-pl-userfield";
  public static final String disconnectedProductImg = "span#imgDisconnectedproduct";
  public static final String clickOnView = "button#btnViewProduct";
  public static final String previousButton = "li.pagination-previous a";
  public static final String selectValueForHistory = "select#ddlPossibleValues";
  public static final String getDeviceIDvalue = "div#product-summary-product-device-id-container";
  public static final String getSerialNumber = "div#product-summary-product-serial-number-container";
  public static final String getErrorTextSiteConfig = "div#divErrors h4";
  public static final String getProductNameInProductLineKey = "div#AttributesTab>table#tblAttributes>tbody>tr>td";
  public static final String backButtonFieldKey = "button#btnProductback";
  public static final String viewButtonForSecondProduct = "table#tblProduct tr:nth-child(2) button";
  public static final String viewButtonForThirdProduct = "table#tblProduct tr:nth-child(3) button";
  public static final String historyButtonkey = "button#btnHistory";
  public static final String createdByInSettingHistory = "div.container-product-data div div:nth-child(5) p";
  public static final String settingCurrentValTextBoxKey = "input#txtSettingCurrentValue";
  public static final String saveSelectedSettingValButton = "button#btnSaveSetting";
  public static final String pendingSettingKey = "button#btnPendingValues";
  public static final String settingPendingvalue = "label#lblQueueFieldValue";
  public static final String displayedSettingTimestamp = "label#lblQueueFieldTimeStamp";
  public static final String cancelButtonForPendingValue = "modal#pendingValuesModal button#btnPendingValues";
  public static final String settingsValueCheckbox = "input#chkSetting";
  public static final String getCurrentValue = "input#txtCurrentValue";
  public static final String getcurrentValHistory = "div.container-product-data p";
  public static final String getCurrrentvalDep = "table#tblhistoricalSetting tbody tr td";
  public static final String endpointHistoryCancelButton = "modal#settingHistoricalModal div.modal-footer modal-footer button";
  public static final String getProductDeviceIdFromSummery = "div#divSummaryTab div:nth-child(3) div:nth-child(2)";
  public static final String getProductSerialNoFromSummery = "div#divSummaryTab div:nth-child(4) div:nth-child(2)";

  // tab-header-product-attributes-container

  // Customize columns
  public static final String customizeColumnDownArrow = "span#product-grid-header-customize-column-dropdown";

  public static final String deviceIdCheckBox = "input#col-product-data";
  public static final String softWareVersionCheckBox = "input#col-registered";
  public static final String statusCheckBox = "input#col-attributes";
  public static final String getStatusText = "label#product-grid-header-filter-items-status-label";
  public static final String getDeviceIDText = "label#product-grid-header-filter-items-device-id-label";
  public static final String getSWVersionText = "label#product-grid-header-filter-items-software-version-label";
  public static final String statusTextonProductlinePage = "h6#product-grid-header-product-status";
  public static final String devideIDTextonProductlinePage = "h6#product-grid-header-device-id-container";
  public static final String softWareVersionTextonProductlinePage = "h6#product-grid-header-software-version-container";

  // Product Attributes, setting and commands
  public static final String productCommandsLinkKey = "h6#control-commands-desktop";
  public static final String productDeactivateButtonKey = "button#btnDeactivateProduct";
  public static final String successOkButtonKey = "button#success-popup-ok";
  // Configure Product line attributes
  public static final String attributesLinkKey = "a#lnkAttributesTab";
  public static final String addAttributesButtonKey = "button#btnAddAttribute";
  public static final String addAttributeNameFieldKey = "input#txtAttributeName";
  public static final String addAttributeGroupName = "input#txtAttributeGroupName";
  public static final String addAttributeDescriptionFieldKey = "input#txtAttributeDescription";
  public static final String addAttributeDataTypeFieldKey = "select#ddlAttributeDataType";
  public static final String addAttributeconstraintsButtonFieldKey = "button#attribute-constraint-btn";
  public static final String addAttributeconstraintsTypeFieldKey = "select#ddlAttributeConstraintType";
  public static final String addAttributeconstraintsAddButtonFieldKey = "button#btnAddConstraint";
  public static final String addAttributeconstraintsTextFieldKey = "input#txtAttributeConstraintValue";
  public static final String addAttributeconstraintsCloseFieldKey = "button#btn-cancel-constraint-attribute";
  public static final String addAttributeLocalIDFieldKey = "input#attribute-localId";
  public static final String addAttributeSaveButtonKey = "button#add-attribute-entry-btn";
  public static final String attributesTextKey = "p#product-line-attributes-grid-data-name";
  public static final String attributesConstraintButtonFieldKey = "button#attribute-constraint-btn";
  public static final String ConfigureText = "h4#lblConfigureEndpoint ";
  public static final String atrTableContent = "div.tab-content th";
  public static final String attributePaginationNext = "li.pagination-next a";
  public static final String attributePaginationPrevious = "li.pagination-previous a";
  public static final String settingsPaginationNext = "pagination-controls#settingPaginationControl li.pagination-next a";
  public static final String settingsPaginationPrevious = "pagination-controls#settingPaginationControl li.pagination-previous a";
  public static final String commandsPaginationNext = "pagination-controls#commandPaginationControl li.pagination-next a";
  public static final String commandsPaginationPrevious = "pagination-controls#commandPaginationControl li.pagination-previous a";

  public static final String locaiIdkey = "input#txtAttributeLocalId";
  public static final String editAttributeLinkKey = "a#lnkEditAttribute";
  public static final String editAttributeNameKey = "input#txtAttributeName";
  public static final String editAttributeDescriptionKey = "input#txtAttributeDescription";
  public static final String editAttributeSaveButtonFieldKey = "button#add-attribute-entry-btn";
  public static final String deleteStaticAttributeFieldKey = "a#lnkDeleteAttribute";
  public static final String deleteLinkKey = "a#lnkDeleteAttribute";
  public static final String deleteConfirmKey = "button#btnDelete";

  public static final String getAttributeName = "table#tblAttributes td";

  // Configure Product line Settings
  public static final String settingsLinkKey = "a[href=\"#divSettingsTab\"]";
  public static final String addSettingsButtonKey = "button#btnAddSetting";
  public static final String addSettingsTypeSelectKey = "select#ddlSettingType";
  public static final String editSettinglinkKey = "a#lnkEditSetting";
  public static final String addSettingTypeNextKey = "button#btn-setting-next";
  public static final String addSettingNameFieldKey = "input#txtSettingName";
  public static final String addSettingGroupNameFieldKey = "input#txtSettingGroupName";
  public static final String addSettingDataTypeFieldKey = "select#ddlSettingDataType";
  public static final String addSettingDefaultValueFieldKey = "input#txtSettingDefaultValue";
  public static final String addSettingLocalIDFieldKey = "input#setting-localId";
  public static final String settingsTextKey = "p#product-line-settings-grid-data-name";
  public static final String addSettingsSaveButtonKey = "button#btnSave";
  public static final String addSettingPossibleValueFieldKey = "#txtSettingPossibleValues";
  public static final String addSettingsConstraintsButtonKey = "button#setting-constraint-btn";
  public static final String addSettingConstraintTypeFieldKey = "select#ddlSettingConstraintType";
  public static final String addSettingConstraintValueFieldKey = "input#txtSettingConstraintValue";
  public static final String addSettingConstraintAddButtonKey = "button#btnAddConstraint";
  public static final String addSettingConstraintCloseButtonKey = "button#btnCancel";
  public static final String deleteSettingsLinkKey = "a#lnkDeleteSetting";
  public static final String expandAllsSettingsButton = "button#expand-collapse-all-settings";
  public static final String getSettingName = "table#tblSettings tbody td:nth-child(2)";
  public static final String checkSettingsNameLink = "div#product-dynamic-endpoint-command-group-details-container> h5";
  public static final String checkCommandsNameLink = "div#product-dynamic-endpoint-command-group-details-row-container> div h5";
  public static final String getCfgSettingValKey = "table#tblSettings td ";
  public static final String getSettingNameProduct = "div#divSettingsTab h5 span";

  // Configure Product Line user Notifications
  public static final String notificationsLinkKey = "a[href=\"#divNotificationTab\"]";
  public static final String addNotificationsButtonKey = "button#btnAddNotification";
  public static final String addNotificationsEventActionKey = "select#ddlNotificationEventAction";
  public static final String addNotificationsNextButtonKey = "button#btn-notification-next";
  public static final String addNotificationsAlertNameKey = "input#txtNotificationName";
  public static final String addNotificationsAlertMessageKey = "input#txtNotificationMessage";
  public static final String addNotificationsAlertRoleLevelKey = "select#ddlNotificationRoleLevel";
  public static final String addNotificationsAlertSeverityKey = "select#ddlNotificationAlertSeverity";
  public static final String addNotificationsAlertUserKey = "select#ddlNotificationUser";
  public static final String addNotificationsAlertDeliveryMethodKey = "select#ddlNotificationDeliveryMethod";
  public static final String addNotificationsAlertSaveButtonKey = "button#btnSave";
  public static final String addNotificationsAlertCancelButtonKey = "button#btnCancel";
  public static final String addNotificationsAlertBackButtonKey = "div#notification-modal-buttons-row-container >button#btn-notification-back";
  public static final String addNotificationsEditAlertlinkKey = "a#lnkEditNotification";
  public static final String addNotificationsDeleteAlertlinkKey = "div#product-line-notification-grid-data-row-actions-container>a#product-line-notification-grid-data-row-delete-alert-link";
  public static final String addNotificationsDeleteAlertYesButtonKey = "div#confirm-delete-popup-notification-div>button#notification-delete";
  public static final String addNotificationsDeleteAlertNoButtonKey = "div#confirm-delete-popup-notification-div>button#confirm-delete-popup-no";
  public static final String notificationsAlertNameKey = "div#product-line-notification-grid-data-row-name-container>p#product-line-notification-grid-data-row-name";
  public static final String webHookDetails = "div#divWebHookNotification";
  public static final String addNotificationsAlertSettingName = "Select#ddlNotificationSettingName";
  public static final String addNotificationsAlertAttributeName = "Select#ddlNotificationAttributeName";
  public static final String getNotificationAleartName = "table#tblNotification tbody td";
  public static final String notificationPaginationNext = "pagination-controls#notificationPaginationControl li.pagination-next a";
  public static final String notificationPaginationPrevious = "li.pagination-previous a";

  // Configure Product line Commands
  public static final String commandsLinkKey = "a[href=\"#divCommandsTab\"]";
  public static final String addCommandsButtonKey = "button#btnAddCommands";
  public static final String addCommandTypeSelectKey = "select#ddlCommandType";
  public static final String addCommandTypeNameFieldKey = "input#txtCommandName";
  public static final String addCommandTypeNextKey = "button#btn-command-next";
  public static final String addCommandNameFieldKey = "input#txtCommandDisplayName";
  public static final String addCommandGroupNameFieldKey = "input#txtCommandGroupName";
  public static final String addCommandDataTypeFieldKey = "select#ddlCommandDataType";
  public static final String addCommandDeviceValueFieldKey = "input#txtCommandDeviceCommand";
  public static final String addCommandPossibleValueFieldKey = "input#txtCommandPossibleValues";
  public static final String addCommandValueTypeFieldKey = "input#command-value-type";
  public static final String commandsTextKey = "p#product-line-commands-grid-data-name";
  public static final String addCommandsSaveButtonKey = "button#btnSave";
  public static final String addCommandCBSaveButtonKey = "div#command-configuration-step-2-valuetypes-action-container > button#add-setting-entry-btn";
  public static final String addPossibleValueFieldKey = "input#txtCommandPossibleValues";

  public static final String deleteStaticCommandFieldKey = "a#product-line-commands-grid-data-delete-link";
  public static final String deleteCmdLinkKey = "a.delete-command-link";
  public static final String deleteCmdConfirmKey = "button#notification-delete";

  public static final String getCommandName = "table#tblCommands tbody td";

  public static final String tokenKey = "div#divLoading";
  public static final String getcommandName = "table#tblCommands td:nth-child(2)";
  public static final String restOutputKey = null;
  public static final String commandDeleteLinkKey = "a.delete-command-link ";
  public static final String commandEditLinkKey = "a#lnkEditCommand";
  // Configure Product line attributes
  public static final String configureProductLineButtonKey = "button#btnHeaderConfigure";
  public static final String addEndpointButtonKey = "button#btnAddEndPoint";
  public static final String addEndpointNameFieldKey = "input#txtEndpointName";
  public static final String addEndpointMfgIdFieldKey = "input#txtEndpointMFGId";
  public static final String addEndpointDescriptionFieldKey = "input#txtEndpointDescription";
  public static final String clickSaveButtonKey = "button#btnSave";
  public static final String backButtonKey = "button#btnBack";
  public static final String backButtonProdKey = "button#btnProductback";
  // Dynamic EP-ProductLine
  public static final String selectDynamicEndPoint = "select#ddlEndPonit";
  public static final String dynamicPointButton = "button#btnEndpoint";
  public static final String dynamicEndPointlinkKey = "div#divEndpoints tbody td";
  public static final String titleMessageDisplayed = "div.toast-title";
  public static final String dynamicEndPointAttributeNameKey = "p#product-dynamic-attributes-grid-data-name";
  public static final String searchDynamicEpbox = "input#txtsearchString";
  public static final String clickGoforSearchDEP = "button#btnSearch";
  public static final String searchSendStartDate = "input#datesearchStartDate";
  public static final String searchSendEndDate = "input#datesearchEndDate";
  public static final String getLastUpadatedDate = "div#divEndpoints table td:nth-child(5)";
  public static final String getErrorTextforSearchDEP = "div#divEndpoints tbody tr";
  public static final String clearFilterButton = "div#divEndpoints button:nth-child(3)";
  // public static final String getDynamicEndPointsettingNameKey = "h5#product-dynamic-endpoint-command-group-name-header";
  public static final String getDynamicEndPointsettingNameKey = "div#settings-text-label >label";
  public static final String getDynamicEndPointUserFieldKey = "p#dynamic-endpoint-userfields-grid-field-name";
  public static final String getDynamicEndPointCommandKey = "div#dynamic-endpoint-command-parameters >label";

  public static final String getDynamicEndPointCommandNameKey = "div#container-product-data-command > div h5";
  public static final String getErrorMessage = "form#add-end-point-form>div p";
  public static final String copyDynamicEndPointButton = "button#btnCopyEndPoint";
  public static final String selectTargetDynamicEp = "select#ddlTargetProductLine";
  public static final String copyToTargetSaveButton = "button#btn-endpoint-clone-Save";
  // public static final String editDEPnameKeyfield="input#edit-endpoint-name";
  public static final String editDynamicEndPointButton = "button#btnEditEndPoint";
  // public static final String editSaveDynamicEpButton="button#edit-endpoint-button";
  // Add OTA group attributes

  public static final String oTATabLinkKey = "li#liOta>a#lnkOta";
  public static final String OTAGroupSearchboxKey = "input#txtSearchItemList";
  public static final String addOTAGroupLinkKey = "button#btnHeaderAdd";
  public static final String addOTAGroupNameFieldKey1 = "input#txtName";
  public static final String addOTAGroupProductLineFieldKey = "select#ddlProductLineId";
  public static final String addOTAGroupHardwareVersionFieldKey = "select#ddlHardwareVersion";
  public static final String addOTAGroupSoftwareVersionFieldKey = "select#ddlSoftwareVersion";
  public static final String addOTAGroupNameFieldKey = "input#txtName";
  public static final String addOTAForceUpdateButtonKey = "input#force-check";
  public static final String addOTAGroupSaveButtonKey = "button#btnSave";
  public static final String addOTAGroupCancelButtonKey = "button#btnCancel";
  public static final String searchOTAGroupResultKey = "ul#list-group > li > a";
  public static final String pickProductFromAvailableList = "#tblUnassingnedProduct > tbody > tr";
  public static final String addToCurrentOTAGroupButtonKey = "#btnAdd";
  public static final String pickProductFromCurrentList = "#tblAssingnedProduct > tbody > tr";
  public static final String addToAvailableOTAGroupButtonKey = "#btnRemove";
  public static final String editOTAGroupButtonKey = "button#btnHeaderEdit";
  public static final String updateButtonKey = "button#btnUpdate";
  public static final String deleteOTAGroupButtonKey = "button#btnHeaderDelete";
  public static final String deleteConfirmationNotificationKeyOTA = "button#btnDelete";
  // Product Sync
  public static final String firmwareDetails = "h6#control-firmware-details-desktop";
  public static final String getOSVersion = "div#product-details-os-version-container";

  // Product Settings
  public static final String productSetting = "h6#control-settings-desktop";
  public static final String productSettingExpandButton = "span#save-settings-button-span";
  public static final String pickFirstGroupFromTheGroupList = "h5#product-settings-row-field-details-header";
  public static final String firstGroupValueFromTheGroupList = "div#settings-parameters input#setting-param-value";
  public static final String firstGroupNameFromTheGroupList = "label#settings-screen-display-label";

  // Product attributes
  public static final String attributesButton = "li a[href=\"#divAttributesTab\"] ";
  public static final String commandButton = "li a[href=\"#divCommandsTab\"] ";
  public static final String attributesValue = "p#product-attributes-grid-data-value";
  public static final String attributesName = "p#product-attributes-grid-data-name";

  // Product userField
  public static final String userFieldButton = "h6#control-product-productuserfields-desktop";
  public static final String userFieldName = "table#tblUserFields td";
  public static final String userFieldNamePL = "table#tblUserFields td";

  // Maintain User
  public static final String admistratorTabLinkKey = "a[title=\"Administrator\"]";
  public static final String maintainUserslinkFieldKey = "a#lnkMaintainUsers";
  public static final String addUserslinkFieldKey = "button#btnHeaderAdd";
  public static final String userId = "input#txtEmail";
  public static final String emailId = "input#txtEmail";
  public static final String secondaryEmail = "input#txtSecEmail";
  public static final String firstName = "input#txtFirstName";
  public static final String lastName = "input#txtLastName";
  public static final String telephone = "input#txtTelephone";
  public static final String userRole = "select.form-control";
  public static final String saveUser = "button#btnUpdate";
  public static final String cancelUser = "button#btnCancel";
  public static final String userIdSearchboxKey = "input#txtContainerSearch";
  public static final String userIdSearchboxResultKey = "div#container-product-data";
  public static final String selectRoleTabLinkKey = "a[href='https://dev-2.portal.us.flex-ci.com/User/List/VIEWER']";
  public static final String selectUserKey = "div#container-product-data";
  public static final String editUserKey = "#btnHeaderEdit";
  public static final String deleteUserKey = "#btnHeaderDelete";
  public static final String userIdSearchbuttonFieldKey = "button#btnSearchGo";
  public static final String userIdUpdatebuttonFieldKey = "#btnUpdate";
  public static final String userdeleteConfirmationOkKey = "#btnDelete";
  public static final String backButtonKey1 = "button#btnBack > span";
  public static final String userdeleteConfirmationCancelKey = "#btnCancel";
  public static final String selectInstallerRoleTabLinkKey = "a[title=\"Installer\"]";
  public static final String selectManagerRoleTabLinkKey = "a[title=\"Manager\"]";
  public static final String selectUserRoleTabLinkKey = "a[title=\"User\"]";
  public static final String selectViewerRoleTabLinkKey = "a[title=\"Viewer\"]";

  // view profile
  public static final String viewProfilelinkFieldKey = "a#lnkViewProfile";
  public static final String editUserProfileLinkKey = "button#btnHeaderEdit";
  public static final String editSecondaryEmail = "input#txtSecEmail";
  public static final String editFirstName = "input#txtFirstName";
  public static final String editLastName = "input#txtLastName";
  public static final String editPhoneNum = "input#txtTelephone";
  public static final String editUserUpdatebuttonFieldKey = "button#btnUpdate";
  public static final String editUserTextMessage = "div#container-content > p";

  // user preferences
  public static final String preferencelinkFieldKey = "div#divUserContextMenu > a#lnkPreferences";
  public static final String preferenceAddbuttonFieldKey = "button#btnHeaderAdd";
  public static final String preferenceeditFieldKey = "#tblUsers > tbody > tr > td:nth-child(4) > a";
  public static final String preferencedelivaryattributeKey = "select#ddlDeliveryAttribute";
  public static final String preferenceValueFieldKey = "input#txtPreferenceValue";
  public static final String preferencesavebuttonFieldKey = "button#btnSave";
  public static final String preferencedelivaryMethodFieldKey = "select#ddlDeliveryMethodName";
  public static final String addedAttributeValueKey = "table#tblUsers > tbody > tr > td:nth-child(1)";

  // About
  public static final String aboutlinkFieldKey = "#lnkAbout";
  public static final String aboutportalVersionFieldKey = "label#shared-about-portal-version-config-labels";
  public static final String aboutSDkVersionFieldKey = "label#shared-about-sdk-version-config-label";
  public static final String aboutAPIVersionFieldKey = "label#shared-about-api-version-config-label";
  public static final String aboutOKButton = "button#btnOk";

  // change company
  public static final String changeCompanyLinkFieldKey = "#lnkChangeCompany";
  public static final String changeCompanyDropDownFieldKey = "select#companyId";
  public static final String changeCompanySubmitFieldKey = "button#btn-submit-company";

  // Add Packages

  public static final String packagesTabLinkKey = "li#liPackages > a#lnkPackages";
  public static final String addPackageButtonFieldKey = "button#btnHeaderAdd";
  public static final String addPackageNameInputFieldKey = "input#txtName";
  public static final String addPackageVersion = "input#txtVersion";
  public static final String addPackageDescriptionFieldKey = "textarea#txtDescription";
  public static final String addPackageSoftwareVersionFieldKey = "input#txtSoftwareVersion";
  public static final String addPackageHardwareVersionFieldKey = "input#txtHardwareVersion";
  public static final String savePackageFieldKey = "button#btnSave > span";
  public static final String getPackageStatus = "table#tblPackageGroupData td:nth-child(3)";
  public static final String downloadManifestLink = "table#tblPackageGroupData td:nth-child(4) a";
  public static final String deletePackageFieldKey = "button#btnDeletePackageGroup";
  public static final String deletePackageConfirmButtonKey = "button#btnDelete";
  public static final String searchPackageFieldKey = "input#txtContainerSearch";
  public static final String goButtonPackageFieldKey = "button#btnSearchGo";
  public static final String viewPackageButtonKey = "#btnViewPackages > span";
  public static final String addpackageDetailsButtonKey = "button#btnAddPackage";
  public static final String selectPackagedetailKey = "select#ddlPackageType";
  public static final String choosePackagedetailKey = "input#file";
  public static final String uploadPackagedetailKey = "button#btnUpload > span";
  public static final String searchPackageResultKey = "table > tbody > tr > td";
  public static final String choosemanifestFileLinkKey = "input[name='importFile']";
  public static final String editpackageDetailsButtonKey = "button#btnUpdatePackage";
  public static final String deletePackageButton = "button#btnDeletePackage";
  public static final String getPackgeName = "div#divPackageDetails td:nth-child(2)";
  // Add Firmware
  public static final String firmwareTabLinkKey = "a#lnkFirmware";
  public static final String packageTabLinkKey = "a#lnkPackages";
  public static final String addPackageButtonKey = "button#btnHeaderAdd";
  public static final String addPackageNameFieldKey = "input#txtName";

  public static final String addSoftwareVersionFieldKey = "input#txtSoftwareVersion";
  public static final String addHardwareVersionFieldKey = "input#txtHardwareVersion";
  public static final String adduploadButtonFieldKey = "div#divFileUpload >span";// "div#divFileUpload > input#file";
  public static final String addPackageSaveButtonFieldKey = "button#btnSave";
  public static final String downloadFirmwareLinkFieldKey = "div#divFileUpload >span";
  public static final String prodLineAttributesName = "p#product-line-attributes-grid-data-name";
  public static final String backButton = "button#btn-product-line-configure-back";
  public static final String uploadFirmwareLinkFieldKey = "input#divFileUpload";
  public static final String uploadLinkFieldKey = "input#file";
  public static final String uploadManifestButtonFieldKey = "table#tblPackageGroupData td:nth-child(5) a";
  public static final String uploadLinkinUploadFile = "//*[@id=\"file\"]";
  public static final String submitManifestButtonFieldKey = "button#btnSubmit";
  public static final String successPopUpButtonFieldKey = "button#success-popup-ok";
  public static final String fwProdLineSearchboxKey = "input#txtSearchItemList";
  public static final String searchFwProdLineResultKey = "ul#list-group > li > a";
  public static final String deleteFirmwareButtonKey = "button#btnDeleteFirmware";
  public static final String deleteConfirmButtonKey = "button#btnDelete";
  public static final String searchFirmwareTextboxKey = "input#txtContainerSearch";
  public static final String searchFirmwareGoButtonKey = "button#btnSearchGo";
  public static final String searchFirmwareResultKey = "table > tbody > tr > td";

  // Reporting Group
  public static final String reportingGroupLinkKey = "a#lnkGroup";
  public static final String reportingGroupSettingsKey = "a#lnkSettings";
  public static final String reportingGroupSiteConfigKey = "a[href=\"#divSiteConfigurationTab\"]";
  public static final String siteConfigUploadInputKey = "input[name=\"importFile\"]";// "div#divFileUpload";//
  public static final String siteConfigSubmitKey = "button#btnSubmit";
  public static final String siteConfigConfirmKey = "button#btnConfirm";
  public static final String siteConfigErrorReasonKey = "tbody#errortable-body >tr >td:nth-child(8)";
  public static final String CancelButton = "button#btnCancel";
  public static final String siteConfigErrorText = "div#divErrors > h4";
  public static final String errorHeader = "h2#site-config-errors-header";
  public static final String pageLoading = "div.loadingDiv";

  public static final String reportingGruopDetailsKey = "div#divGroupDetails";

  public static final String reportingGroupSearchBoxKey = "input#txtSearchItemList";
  public static final String reportingGroupSearchResultsKey = "ul#lnkDetailsPage";
  public static final String addReportingGrouplinkKey = "button#btnHeaderAdd";
  public static final String addReportingGroupNameKey = "input#txtGroupName";
  public static final String addReportingGroupSaveKey = "button#btnSave";
  public static final String editReportingGroupKey = "button#btnHeaderEdit";
  public static final String editGroupNamefieldKey = "input#edit-rgroup-name";
  public static final String editGroupdetailsSaveKey = "button#btnSave";
  public static final String editGroupdetailsCancelKey = "div#rgroup-modal-buttons-row-container>button#btn-cancel-add-rgroup";
  public static final String deleteReportingGroupButtonKey = "button#btnHeaderDelete";
  public static final String deleteReportingGroupcConfirmButtonKey = "button#btnDelete > span";

  // ReportingGroup Users

  public static final String reportingGroupUsersLinkKey = "a#lnkUsers";
  public static final String reportingGroupUserAddButtonKey = "button#btnAddUser";
  public static final String reportingGroupUserRemoveButtonKey = "button#btnRemoveUser";
  public static final String reportingGroupAvailableUserKey = "table#tblUnassignedUser tbody td ";
  public static final String reportingGroupCurrentUserKey = "table#tblAssignedUser tbody td";
  public static final String selectAvailableVirtualProductKey = "#tblUnassignedVirtualProduct > tbody > tr:nth-child(1) > td:nth-child(1)";
  public static final String addButtonFieldKey = "button#btnAddProduct > span";
  public static final String selectCurrentVirtualProductKey = "#tblAssignedVirtualProduct > tbody > tr:nth-child(1) > td:nth-child(1)";
  public static final String removeButtonFieldKey = "button#btnRemoveProduct > span";
  public static final String selectUserFieldTabKey = "ul#divProductLineTab > li >a#lnkUserFeild";
  public static final String editLinkFieldkey = "a#lnkEdit";
  public static final String inputUserFieldNameKey = "input#txtUserFieldValue";
  public static final String submitButtonFieldKey = "button#submit";
  public static final String selectUsersTabKey = "ul#divProductLineTab > li > a#lnkUsers";
  public static final String selectAvailableUserKey = "#tblUnassignedUser > tbody > tr:nth-child(1) > td:nth-child(1)";
  public static final String addButtonUserKey = "button#btnAddUser > span";

  // ReportingGroupUserFields
  public static final String reportingGroupUserFieldsLinkKey = "a#lnkUserFeild";
  public static final String reportingGroupUserFieldsEditKey = "a#lnkEdit";
  public static final String reportingGroupUserFieldsValueInputKey = "input#txtUserFieldValue";
  public static final String reportingGroupUserFieldsSaveKey = "button[type=\"submit\"]";
  public static final String reportingGroupUserFieldsSettingKey = "a#lnkSettings span";
  public static final String reportingGroupAddUserFieldsKey = "button#btnAddGroupUserField";
  public static final String reportingGroupUserFieldsNameKey = "input#txtUserFieldName";
  public static final String reportingGroupUserFieldsDescriptionKey = "input#txtUserFieldDescription";
  public static final String reportingGroupUserFieldsAPIKey = "input#txtUserFieldApiKey";
  public static final String reportingGroupUserFieldsDataTypeKey = "select#ddlUserFieldDataType";
  public static final String reportingGroupUserFieldsOrderKey = "input#txtUserFieldOrder";
  public static final String reportingGroupAddUserFieldsSaveKey = "button#btnSave";
  public static final String reportingGroupDeleteUserFieldslinkKey = "a#lnkDelete";
  public static final String reportingGroupDeleteUserFieldsConfirmButtonKey = "button#btnDelete";
  public static final String reportingGroupUserFieldsEditLinkKey = "a#lnkEdit";
  public static final String getReportingGroupUserFieldName = "table#tblUserField tbody td";

  // Configure product Line User Fields

  public static final String userFieldLinkKey = "a[href=\"#divUserFieldsTab\"]";
  public static final String userFieldLinkKey1 = "h6#control-product-userfields-desktop";
  public static final String addUserFieldButtonKey = "button#btnAddUserFields";
  public static final String addUserFieldNameFieldKey = "input#txtUserFieldName";
  public static final String addUserFieldDescriptionFeildKey = "input#txtUserFieldDescription";
  public static final String addUserFieldDataTypeFieldKey = "select#ddlUserFieldDataType";
  public static final String addUserFieldAPIFieldKey = "input#txtUserFieldApiKey";
  public static final String addUserFieldOrderFieldKey = "input#txtUserFieldOrder";
  public static final String addUserFieldSaveButtonKey = "button#btnSave";
  public static final String edituserFieldValueKey = "input#txtProductlineUserfieldValue";
  public static final String addUserFieldEditButtonKey = "a#lnkEditUserfield";
  public static final String addUserFieldDeleteButtonKey = "a#product-line-userfields-grid-data-delete-link";
  public static final String addUserFieldDeleteConfirmYesButtonKey = "button#notification-delete";
  public static final String addUserFieldDeleteConfirmNoButtonKey = "button#confirm-delete-popup-no";
  public static final String addDynamicEPUserFieldEditButtonKey = "a#lnkEditUserfield";
  public static final String dynamicEPUserFieldDeleteLinkKey = "a.delete-productuserfield-link";
  public static final String getUserFieldsName = "table#tblUserFields td";
  public static final String userFieldLink = "h6#control-product-userfields-desktop";
  public static final String getStaticEpUserFieldsName = "div#product-line-userfields-grid-data-name-container > p";
  public static final String getuserNameDisplayed = "#divUserInformation > a > b";
  public static final String userFieldEditButton = "button#btnEditUserField";
  public static final String userFieldValueKey = "input#txtProductlineUserfieldValue";
  // Add Virtual products

  public static final String virtualProductsLinkFieldKey = "a[href=\"#divVirtualProductTab\"]";
  public static final String addVirtualProductsLinkFieldKey = "button#btnAddVirtualProduct";
  public static final String addVirtualProductsInputFieldKey = "input#txtVirtualProductName";
  public static final String addVirtualProductsSelectUserFieldKey = "select#ddlVirtualProductUser";
  public static final String addVirtualProductsSelectProductFieldKey = "select#ddlVirtualProduct";
  public static final String addVirtualProductsSaveButtonFieldKey = "button#btnSave";
  public static final String editVirtualProductsButtonFieldKey = "button#btnEditVirtualProduct";
  public static final String editVirtualProductsUpdateButtonFieldKey = "button#btnSave";
  public static final String deleteVirtualProductsButtonFieldKey = "div#virtual-product-grid-data-delete-container > a#modal-content-prompt-delete";
  public static final String deleteVirtualProductsNotificationButtonFieldKey = "button#notification-delete";
  public static final String viewProductsButtonFieldKey = "button#btnViewProduct";
  public static final String getVirtualProductsidValueKey = "#divSummaryTab div:nth-child(6) div:nth-child(2)";
  public static final String viewProductBackButtonKey = "div#divActions > button#btnProductback";
  public static final String viewProductVirtualproductIdKey = "#tblVirtualProduct > tbody > tr > td:nth-child(2)";
  public static final String verifyProductSummaryDeviceIdKey = "#divSummaryTab > div:nth-child(3) > div.col-lg-4.col-md-6.col-sm-8";
  public static final String verifyProductSummaryProductIdKey = "div#product-summary-product-product-id-container";
  public static final String verifyProductDeviceIDKey = "div#product-grid-data-row-static-endpoint-deviceid-container > p#product-grid-data-row-static-endpoint-device-id";
  public static final String deactivateProductCommandsLinkKey = "button#btnDeactivateProduct";
  public static final String productDeactivateButtonFieldKey = "button#btnDeactivateProduct";
  public static final String productDeactivateSuccessButtonKey = "button#success-popup-ok";
  public static final String productLink = "a#lnkProductTab";

  // Notifications/Alerts

  public static final String webHookButtonkey = "li#liwebhook";
  public static final String websocketButtonKey = "a#lnkWebHookDetailsPage";
  public static final String webHookNotifications = "div.webhook >div.data";
  public static final String clickOnProductLine = "a.product > li";
  public static final String getUnsubscribedNotificationName = "p#product-line-unsubscribed-notification-grid-data-row-name";
  public static final String getSubscribedNotificationName = "table#tblSubscribedNotificationData td";
  public static final String subscribeAlert = "a.subscribe-alert";
  public static final String unsubscribeAlert = "a#lnkUnsubscribe";
  public static final String clickSaveButtonAlert = "button#btnSave";
  public static final String clickOnWebHookCheckBox = "//input[@id=\"Websocket\"]";
  public static final String clickOnWebSocketCheckBox = "//input[@id=\"WebHook\"]";
  public static final String clickOnEmailCheckBox = "input[data-checkboxname=\"Email\"]";
  public static final String notificationHeader = "h5#subscribed-notification-header";
  public static final String clickOnProductLink = "a#lnkProductLine";
  public static final String updateCompanyButton = "button#btnUpdate";
  public static final String editCompany = "button#btnHeaderEdit";
  public static final String websocketMessage = "span#spnMessage +h3 +div +div>ul>li";
  public static final String getErrorMessageforSubsrcibe = "p.result-message";
  public static final String clickCancelForAlert = "button#btn-subscribe-alert-cancel";

  public static final String searchBoxProductKey = "input#txtContainerSearch";
  public static final String ViewButtonOfProductKey = "button#btnViewProduct";
  public static final String getCurrentValueOfProduct = "div#product-attributes-grid-data-value-container";

  public static final String deleteProductNotification = "div#confirm-delete-popup-notification-div>button#notification-delete";
  public static final String deleteProductButton = "button#btnDeleteProduct";

  // Sort field names
  public static final String endpointNameKey = "th#btnSortEndPointName";
  public static final String endpointNameSortingArrow = "th#btnSortEndPointName span";
  public static final String endpointMfgIdKey = "th#btnSortMFGID";
  public static final String endpointMfgIdSortingArrow = "th#btnSortMFGID span";
  public static final String endpointSerialNumberKey = "th#btnSortSerialNo";
  public static final String endpointSerialNumberSortingArrow = "th#btnSortSerialNo span";
  public static final String endpointStatusKey = "th#btnSortStatus";
  public static final String endpointStatusSortingArrow = "th#btnSortStatus span";
  public static final String endpointlastUpdatedKey = "th#btnSortDate";
  public static final String endpointlastUpdatedSortingArrow = "th#btnSortDate span";

  public static final String productNameKey = "th#btnSortDeviceId:nth-child(1)";
  public static final String productNameSortingArrow = "th#btnSortDeviceId:nth-child(1) span";
  public static final String productStatusKey = "#product-grid-header-product-status > a";
  public static final String productStatusSortingKey = "#product-grid-header-product-status > span";
  public static final String productDeviceIdKey = "th#btnSortDeviceId:nth-child(3)";
  public static final String productDeviceIdSortingArrow = "th#btnSortDeviceId:nth-child(3) span";
  public static final String productSoftwareVersionKey = "th#btnSortDeviceId:nth-child(4)";
  public static final String productSoftwareVersionSortingArrow = "th#btnSortDeviceId:nth-child(4) span";

  // Add Company

  public static final String flexAdminUserLinkKey = "a#lnkFlexAdminUser";
  public static final String flexAdminCreateCompanyKey = "button#btnHeaderAdd";
  public static final String flexAdminEditKey = "button#btnHeaderEdit";
  public static final String addCompanyCuidKey = "input#txtCuid";
  public static final String addCompanyNameKey = "input#txtName";
  public static final String addCompanyDescriptionKey = "input#txtDescription";
  public static final String addCompanyUrlKey = "input#txtUrl";
  public static final String addCompanyLogoUrlKey = "input#txtLogoUrl";
  public static final String addCompanyEmailKey = "input#txtCompanyEmail";
  public static final String addCompanySaveKey = "button#btnSave";
  public static final String addCompanyOptionKey = "button#btn-config-company";
  public static final String queueTypeSelectKey = "select#67517563-729c-4b8a-828f-71c8ea662012";
  public static final String brokerServiceTypeSelectKey = "select#b99fa8e4-742c-488f-ae22-8be09eeb27f8";
  public static final String authenticationTypeSelectKey = "select#c386e604-d9c1-491a-bacd-d4aedc52fdd3";
  public static final String optionCloseKey = "button#btn-cancel-constraint-configuration";

  public static final String addCompanyCancelKey = "button#btnCancel";
  public static final String messageKey = "#theMessage";
  public static final String companyUpdateKey = "button#btnUpdate";
  public static final String companyDeleteKey = "button#btnHeaderDelete";
  public static final String expandAttribute = "button#btnExpandSetting";
  public static final String clickExpandCollapseButtonKey = "div#divSettingsTab button#btnExpandSetting";
  public static final String explandSetting = "div#divSettingsTab button:nth-child(2)";
  public static final String selectSettingValueLinkKey = "div#product-settings-field-details-container>h5";
  public static final String selectSettingValueKey = "select#setting-param-value";
  public static final String getsettingsValueKey = "div#settings-form-type-text-historical-button>input";
  public static final String getAttributeGroupName = "div#divAttributesTab h5 span";
  public static final String companyName = "div#divName";
  public static final String expandDEPAttribute = "div#divAttributesTab button";
  // success Message

  public static final String successMessage = "span.toast-message";

  public static final String newPasswordInputFieldKey = "loginForm.verifyPassword";
  public static final String newPasswordLabelKey = "h2.create-profile";

  // import export endpoint configuration
  public static final String importConfigButton = "button#btnImportEndPoint";
  public static final String importProductLine = "button#btnHeaderImport";
  public static final String importEndPoint = "input#file";
  public static final String endpointExportButton = "button#btnExportEndPoint";

  public static final String searchCompanyBox = "input#txtSearchItemList";
  public static final String searchCompanyResultKey = "ul#list-group > li> a#lnkDetailsPage";

  // signalR[Websocket]
  public static final String websocketUserId = "input#txtUserId";
  public static final String websocketCompanyId = "input#txtCompanyId";
  public static final String websocketRegisterUser = "button#btnRegister";
  public static final String webSockectConnectedStatus = "span#spnMessage";
  public static final String websocketNotification = "div.signalR ul li:last-child";
}
