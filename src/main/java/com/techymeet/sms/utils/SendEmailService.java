package com.techymeet.sms.utils;

import com.techymeet.sms.model.EmailModel;

public interface SendEmailService {

	String sendStudentRegisterEmail(String toaddress, String bodyContent, String subject, EmailModel model);

	String sendTaskAssignEmail(String toAddress, String bodyContent, String subjects, EmailModel model);

}
