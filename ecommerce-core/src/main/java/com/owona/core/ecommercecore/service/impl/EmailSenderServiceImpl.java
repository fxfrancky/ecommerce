package com.owona.core.ecommercecore.service.impl;

import com.owona.core.ecommercecore.model.Client;
import com.owona.core.ecommercecore.model.Code;
import com.owona.core.ecommercecore.service.CodeService;
import com.owona.core.ecommercecore.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    @Autowired
    private CodeService codeService;
    @Autowired
    private MailSender mailSender;
    @Value("${fromAddress}")
    private String fromAddress;
    @Value("${websiteAddr}")
    private String websiteAddr;

    public void sendMail(String toAddress, String subject, String msgBody){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(fromAddress);
        msg.setTo(toAddress);
        msg.setSubject(subject);
        msg.setText(msgBody);
        mailSender.send(msg);
    }

    public void sendActiveCode(Client client){
        List<Code> codes = codeService.findByCodeTypeAndClient(0, client);
        String msgBody = "Click or copy this link to the browser -> http://" + websiteAddr + "/rg/";
        for(Code code : codes){
            msgBody = msgBody + code.getCodeStr();
            break;
        }
        sendMail(client.getEmail(), "Active Your Account", msgBody);

    }

    public void sendResetPasswordCode(Client client){
        Code code = new Code();
        code.setCodeDate(new Date());
        code.setCodeType(1);
        code.setClient(client);

        codeService.save(code);
        String msgBody = websiteAddr + "/rp/" + code.getCodeStr();
        sendMail(client.getEmail(), "Reset Your Passowrd", msgBody);
    }
}
