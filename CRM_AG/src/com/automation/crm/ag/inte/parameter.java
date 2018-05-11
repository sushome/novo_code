package com.automation.crm.ag.inte;

import org.openqa.selenium.By;

public class parameter{

    public String[] url(){
        String[] url = new String[10];
        url[0] = "http:// crm_login";
        return url;
    }

    public String[] namePsw(){
        String[] np = new String[5];
        np[0] = "role1";
        np[1] = "password";
        np[2] = "role2";
        np[3] = "role3";
        return np;
    }

    public By[] by(){
        By[] by = new By[100];
        by[0] = By.xpath("//input[@id=\"sap-user\"]");       //username
        by[1] = By.xpath("//input[@id=\"sap-password\"]");   //password
        by[2] = By.xpath("//div[@id=\"sap-language-dropdown-btn\"]");   //language select
        by[3] = By.xpath("//tr[@id=\"SL1-key-16\"]");
        by[4] = By.xpath("//a[@id=\"LOGON_BUTTON\"]");
        by[5] = By.xpath("//a[contains(text(),'Inside Sales Support WSCA')]");
        by[6] = By.xpath("//a[contains(@id,'ZSL-CYCLE')]/parent::li/div");
        by[7] = By.xpath("//a[contains(@id,'SLS-OPP-SR')]");
        by[8] = By.xpath("//img[@title=\"New (Ctrl+N)\"]");
        by[9] = By.xpath("//span[@title=\"ZOGA\"]");
        by[10] = By.xpath("//input[contains(@id,'struct.description')]");
        by[11] = By.xpath("//input[contains(@id,'btopporth_struct.expect_end')]");
        by[12] = By.xpath("//input[contains(@id,'btpartnerprospect_partnerno')]");
//        by[13] = By.xpath("//*[@id=\"C29_W96_V98_V111_V112_btemployee_partnerno\"]");
        by[14] = By.xpath("//input[contains(@id,'btendcustomer_partnerno')]");
        by[15] = By.xpath("//a[contains(@id,'btopporth_struct.type-btn')]");
        by[16] = By.xpath("//a[@key=\"0001\"]");
        by[17] = By.xpath("//span[@title=\"BR10\"]");
//        by[18] = By.xpath("//span[@id=\"C44_W157_V158_V159_btqrsorgdet_table[2].dis_channel\"]");
        by[18] = By.xpath("//span[contains(@id,'btqrsorgdet_table[2].dis_channel')]");
        by[19] = By.xpath("//*[@id=\"C29_W96_V98_V111_V112_btopporth_struct.type-btn\"]");
        by[20] = By.xpath("//div[@id=\"C29_W96_V98_V111_V112_btopporth_struct.type__items\"]/child::ul//a[@key=\"0005\"]");
        by[21] = By.xpath("//a[@title=\"Save (Ctrl+S)\"]/child::span/b");   //save
        by[22] = By.xpath("//*[@id=\"LOGOFF\"]");
        by[23] = By.xpath("//span[@id=\"C29_W96_V98_V111_V112_btadminh_struct.object_id\"]");
        by[24] = By.xpath("//input[contains(@id, 'search_parameters[5].VALUE1')]");
        by[25] = By.xpath("//a[contains(@id, 'Searchbtn')]/child::span/b");
        by[26] = By.xpath("//a[contains(@id,'result_table[1].description')]");
        by[27] = By.xpath("//a[contains(@id,'thtmlb_button_6')]");
        by[28] = By.xpath("//span[@title=\"ZQCN\"]");
        by[29] = By.xpath("//span[@title=\"1213261753\"]");
        by[30] = By.xpath("//div[@class=\"th-box2\"]//div[@class=\"th-ddlb-container\"]//a[contains(@id,'btpartnerset_zlvl_1_aprer-btn')]");   // Requested Bid Approve
        by[31] = By.xpath("//div[contains(@id, 'btpartnerset_zlvl_1_aprer__items')]/child::ul//a[@key=\"2900723980\"]");
        by[32] = By.xpath("//div[contains(@id, 'sqhoverview.do_0002__ajax_area')]//ul[@class=\"th-tb\"]//a[contains(@id, 'but1')]");   // GTN Simulation Tool
        by[33] = By.xpath("//span[@title=\"BRAZIL\"]");
        by[34] = By.xpath("//div[@class=\"th-box2\"]//div[@class=\"th-ddlb-container\"]//a[contains(@id,'btstatush_status_current-btn')]");    // Status
        by[35] = By.xpath("//div[contains(@id, 'btstatush_status_current__items')]/child::ul//a[@key=\"E0007\"]");
        by[36] = By.xpath("//a[contains(@id, 'ZT-WORKLST')]/parent::li/div");
        by[37] = By.xpath("//a[contains(@id, 'CT-WORKLIS')]");
        by[38] = By.xpath("//span[contains(@id,'btadminh_struct.object_id')]");
        by[39] = By.xpath("//a[@id=\"ZLA_PRICER50045773\"]");
        by[41] = By.xpath("//a[@id=\"table[1].wi_text\"]");
        by[42] = By.xpath("//a[contains(@id, 'btn_Execute')]");
        by[43] = By.xpath("//span[@id=\"WD018A-focus\"]/div");
        by[44] = By.xpath("//textarea[@id=\"WD018D\"]");
        by[45] = By.xpath("//span[@id=\"WD01AB\"]/a/span");
        by[46] = By.xpath("//a[contains(@id,'SLS-QUT-SR')]");
        by[47] = By.xpath("//input[contains(@id, 'btqslsquot_parameters[5].VALUE1')]");
        by[48] = By.xpath("//div[@id=\"WD018E\"]//div");
        by[49] = By.xpath("//img[@alt=\"Edit\"]");
        by[50] = By.xpath("//div[contains(@id, 'btstatush_status_current__items')]/child::ul//a[@key=\"E0003\"]");
        by[51] = By.xpath("//a[contains(@id, 'SEARCH_BTN')]/child::span/b");
        by[52] = By.xpath("//span[contains(@id,'BTDocFlow_Table[2].OBJECTID')]");
        by[53] = By.xpath("//a[@id=\"Z_OECSR50054835\"]");
        by[54] = By.xpath("//a[contains(@id,'SLS-SLO-SR')]");
        by[55] = By.xpath("//input[contains(@id,'btqslscontr_parameters[4].VALUE1')]");
        by[56] = By.xpath("//span[@title=\"YROR\"]");
        by[57] = By.xpath("//input[contains(@id,'btsalesset_struct.po_number_sold')]");
        by[58] = By.xpath("//input[contains(@id,'btsalesset_struct.po_date_sold')]");
        by[59] = By.xpath("//a[contains(@id,'btsalesset_struct.cust_group3-btn')]");
        by[60] = By.xpath("//a[@key=\"CU2\"]");
        by[61] = By.xpath("//img[@alt=\"Notes\"]");
        by[62] = By.xpath("//div[contains(@id,'sohoverview.do_0012__ajax_area')]//img[@title=\"New (Ctrl+N)\"]");
        by[63] = By.xpath("//select[contains(@id,'btpartnerset_zlvl_1_aprer')]");
        by[64] = By.xpath("//textarea[contains(@id,'text_lines')]");
        by[65] = By.xpath("//img[@alt=\"Back\"]");
        by[66] = By.xpath("//span[@title=\"ZQGD\"]");
        by[67] = By.xpath("//span[contains(text(),'Singapore')]");
        by[68] = By.xpath("//label[contains(@id,'thtmlb_label_21')]");
        by[69] = By.xpath("//a[contains(@id,'btdocflow_table[2].id_description')]");
        by[70] = By.xpath("//a[contains(@id,''Table_pag_pg-5)]/span");
        by[71] = By.xpath("//span[@title=\"YBOR\"]");
        return by;
    }
}

