package com.cloudcoin.bank;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestPages {


    @RequestMapping(value = "/sandbox")
    public String testSandbox() {
        return htmlHome;
    }

    @RequestMapping(value = "/sandbox/about")
    public String testAbout() {
        return htmlAbout;
    }

    @RequestMapping(value = "/sandbox/contact")
    public String testContact() {
        return htmlContact;
    }

    @RequestMapping(value = "/sandbox/cash_check")
    public String testCashCheck() {
        return htmlCashCheck;
    }

    @RequestMapping(value = "/sandbox/deposit")
    public String testDeposit() {
        return htmlDeposit;
    }

    @RequestMapping(value = "/sandbox/deposit_with_change")
    public String testDepositGetChange() {
        return htmlDepositGetChange;
    }

    @RequestMapping(value = "/sandbox/echo")
    public String testEcho() {
        return htmlEcho;
    }

    @RequestMapping(value = "/sandbox/get_receipt")
    public String testGetReceipt() {
        return htmlGetReceipt;
    }

    @RequestMapping(value = "/sandbox/mark_for_sale")
    public String testMarkForSale() {
        return htmlMarkForSale;
    }

    @RequestMapping(value = "/sandbox/print_welcome")
    public String testPrintWelcome() {
        return htmlPrintWelcome;
    }

    @RequestMapping(value = "/sandbox/show_coins")
    public String testShowCoins() {
        return htmlShowCoins;
    }

    @RequestMapping(value = "/sandbox/withdraw")
    public String testWithdraw() {
        return htmlWithdraw;
    }

    @RequestMapping(value = "/sandbox/write_check")
    public String testWriteCheck() {
        return htmlWriteCheck;
    }

    
    public static final String htmlHome = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "<meta charset=\"utf-8\">\n" +
            "<title>CloudBank Software home</title>\n" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "<meta name=\"description\" content=\"CloudCoin powning software with the RAIDA\">\n" +
            "<meta name=\"author\" content=\"Sean Worthington\">\n" +
            "\n" +
            "<link href=\"../css/bootstrap2.css\" rel=\"stylesheet\">\n" +
            "<style type=\"text/css\">\n" +
            "      body {\n" +
            "        padding-top: 20px;\n" +
            "        padding-bottom: 40px;\n" +
            "      }\n" +
            "      /* Custom container */\n" +
            "      .container-narrow {\n" +
            "        margin: 0 auto;\n" +
            "        max-width: 700px;\n" +
            "      }\n" +
            "      .container-narrow > hr {\n" +
            "        margin: 30px 0;\n" +
            "      }\n" +
            "      /* Main marketing message and sign up button */\n" +
            "      .jumbotron {\n" +
            "        margin: 60px 0;\n" +
            "        text-align: center;\n" +
            "      }\n" +
            "      .jumbotron h1 {\n" +
            "        font-size: 72px;\n" +
            "        line-height: 1;\n" +
            "      }\n" +
            "      .jumbotron .btn {\n" +
            "        font-size: 21px;\n" +
            "        padding: 14px 24px;\n" +
            "      }\n" +
            "      /* Supporting marketing content */\n" +
            "      .marketing {\n" +
            "        margin: 60px 0;\n" +
            "      }\n" +
            "      .marketing p + h4 {\n" +
            "        margin-top: 28px;\n" +
            "      }\n" +
            "    </style>\n" +
            "<link href=\"../css/bootstrap-responsive.css\" rel=\"stylesheet\">\n" +
            "\n" +
            "<!--[if lt IE 9]>\n" +
            "      <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\n" +
            "    <![endif]-->\n" +
            "\n" +
            "</head>\n" +
            "<body>\n" +
            "<div class=\"container\">\n" +
            "<div class=\"row-fluid marketing\">\n" +
            "<table>\n" +
            "<tr>\n" +
            "<td>\n" +
            "<h1 class=\"muted\">CloudCoin Consortium CloudServer</h1>\n" +
            "</td>\n" +
            "</tr>\n" +
            "</table>\n" +
            "<div class=\"masthead\">\n" +
            "<ul class=\"nav nav-pills pull-right\">\n" +
            "<li class=\"active\" class=\"btn btn-small\"><a href=\"#\" class=\"btn btn-small\"><b> Home</b></a></li>\n" +
            "<li><a href=\"/sandbox/about/\" class=\"btn btn-small\">About</a></li>\n" +
            "<li><a href=\"/sandbox/contact/\" class=\"btn btn-small\">Contact</a></li>\n" +
            "</ul>\n" +
            "</div>\n" +
            "<hr>\n" +
            "<div class=\"row-fluid marketing\">\n" +
            "</div>\n" +
            "<div class=\"jumbotron\">\n" +
            "<h1>CloudServer allows your software to Pown CloudCoins!</h1>\n" +
            "<p class=\"lead\">We are writing classes in every langauge so your software can pown (password own) CloudCoins.\n" +
            "The CloudServer provides a service orientated, restful API over HTML or HTTPS.\n" +
            "</p>\n" +
            "<a class=\"btn btn-large btn-success\" href=\"https://github.com/worthingtonse/Bank\">Git The Open Source MIT Code </a>\n" +
            "</div>\n" +
            "<hr>\n" +
            "<div class=\"row-fluid marketing\">\n" +
            "<div class=\"span6\">\n" +
            "<h1>CloudServer Services Categories</h1>\n" +
            "<a href=\"../sandbox/print_welcome\">Print Welcome Service</a>\n" +
            "<br>\n" +
            "<h2>CloudBanking</h2>\n" +
            "<a href=\"../sandbox/echo\">Echo Service</a>\n" +
            "<br>\n" +
            "<a href=\"../sandbox/show_coins\">Show Coins Service</a>\n" +
            "<br>\n" +
            "<a href=\"../sandbox/deposit\">Deposit One Stack Service</a>\n" +
            "<br>\n" +
            "<a href=\"../sandbox/withdraw\">Withdraw One Stack Service</a>\n" +
            "<br>\n" +
            "<a href=\"../sandbox/get_receipt\">Get Receipt Service</a>\n" +
            "<br>\n" +
            "<a href=\"../sandbox/write_check\">Write Check Service</a>\n" +
            "<br>\n" +
            "<a href=\"../sandbox/cash_check\">Cash Check Service</a>\n" +
            "<br>\n" +
            "<a href=\"../sandbox/mark_for_sale\">Mark Coins For Sale</a>\n" +
            "<br>\n" +
            "<a href=\"../sandbox/deposit_with_change\">Deposit With Change</a>\n" +
            "<br>\n" +
            "\n" +
            "<br>\n" +
            "<br>\n" +
            "<br>\n" +
            "Github for Open Source MIT software: <a href=\"https://github.com/worthingtonse/Bank\"> https://github.com/worthingtonse/Bank</a>\n" +
            "</div>\n" +
            "</div>\n" +
            "<hr>\n" +
            " \n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>";

    public static final String htmlAbout = "\n" +
            "\n" +
            "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "<meta charset=\"utf-8\">\n" +
            "<title>CloudBank Software home</title>\n" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "<meta name=\"description\" content=\"CloudCoin powning software with the RAIDA\">\n" +
            "<meta name=\"author\" content=\"Sean Worthington\">\n" +
            "\n" +
            "<link href=\"../css/bootstrap2.css\" rel=\"stylesheet\">\n" +
            "<style type=\"text/css\">\n" +
            "      body {\n" +
            "        padding-top: 20px;\n" +
            "        padding-bottom: 40px;\n" +
            "      }\n" +
            "\n" +
            "      /* Custom container */\n" +
            "      .container-narrow {\n" +
            "        margin: 0 auto;\n" +
            "        max-width: 700px;\n" +
            "      }\n" +
            "      .container-narrow > hr {\n" +
            "        margin: 30px 0;\n" +
            "      }\n" +
            "\n" +
            "      /* Main marketing message and sign up button */\n" +
            "      .jumbotron {\n" +
            "        margin: 60px 0;\n" +
            "        text-align: center;\n" +
            "      }\n" +
            "      .jumbotron h1 {\n" +
            "        font-size: 72px;\n" +
            "        line-height: 1;\n" +
            "      }\n" +
            "      .jumbotron .btn {\n" +
            "        font-size: 21px;\n" +
            "        padding: 14px 24px;\n" +
            "      }\n" +
            "\n" +
            "      /* Supporting marketing content */\n" +
            "      .marketing {\n" +
            "        margin: 60px 0;\n" +
            "      }\n" +
            "      .marketing p + h4 {\n" +
            "        margin-top: 28px;\n" +
            "      }\n" +
            "    </style>\n" +
            "<link href=\"../css/bootstrap-responsive.css\" rel=\"stylesheet\">\n" +
            "\n" +
            "<!--[if lt IE 9]>\n" +
            "      <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\n" +
            "    <![endif]-->\n" +
            "\n" +
            "</head>\n" +
            "<body>\n" +
            "<div class=\"container\">\n" +
            "<div class=\"masthead\">\n" +
            "<ul class=\"nav nav-pills pull-right\">\n" +
            "<li class=\"active\" class=\"btn btn-small\"> <a href=\"/sandbox\" class=\"btn btn-small\">Home</a></li>\n" +
            "<li><a href=\"/sandbox/about\" class=\"btn btn-small\"><b>About</b></a></li>\n" +
            "<li><a href=\"/sandbox/contact\" class=\"btn btn-small\">Contact</a></li>\n" +
            "</ul>\n" +
            "<h3 class=\"muted\">CloudCoin Consortium CloudBank</h3>\n" +
            "</div>\n" +
            "<hr>\n" +
            "<div class=\"jumbotron\">\n" +
            "<h1>About CloudBank</h1>\n" +
            "<p class=\"lead\">Written in ASPX.NET\t</p>\n" +
            "<p class=\"lead\">File Based Storage</p>\n" +
            "<p class=\"lead\">Three secure services that are on: Echo Services, Import One Stack and Get Receipts. </p>\n" +
            "<p class=\"lead\">Three unsecure services that are turned off by default: Print Welcome Services, Export One Stack and Show Coins. </p>\n" +
            "<p class=\"lead\">Comming soon: Change maker service, fraction service (CloudCents). </p>\n" +
            "<a class=\"btn btn-large btn-success\" href=\"https://github.com/worthingtonse/Bank\">Git The Open Source MIT Code </a>\n" +
            "</div>\n" +
            "<hr>\n" +
            "<div class=\"footer\">\n" +
            "<p>&copy; Company 2017</p>\n" +
            "</div>\n" +
            "</div> \n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>\n";

    public static final String htmlContact = "\n" +
            "\n" +
            "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "<meta charset=\"utf-8\">\n" +
            "<title>CloudBank Software home</title>\n" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "<meta name=\"description\" content=\"CloudCoin powning software with the RAIDA\">\n" +
            "<meta name=\"author\" content=\"Sean Worthington\">\n" +
            "\n" +
            "<link href=\"../css/bootstrap2.css\" rel=\"stylesheet\">\n" +
            "<style type=\"text/css\">\n" +
            "      body {\n" +
            "        padding-top: 20px;\n" +
            "        padding-bottom: 40px;\n" +
            "      }\n" +
            "\n" +
            "      /* Custom container */\n" +
            "      .container-narrow {\n" +
            "        margin: 0 auto;\n" +
            "        max-width: 700px;\n" +
            "      }\n" +
            "      .container-narrow > hr {\n" +
            "        margin: 30px 0;\n" +
            "      }\n" +
            "\n" +
            "      /* Main marketing message and sign up button */\n" +
            "      .jumbotron {\n" +
            "        margin: 60px 0;\n" +
            "        text-align: center;\n" +
            "      }\n" +
            "      .jumbotron h1 {\n" +
            "        font-size: 72px;\n" +
            "        line-height: 1;\n" +
            "      }\n" +
            "      .jumbotron .btn {\n" +
            "        font-size: 21px;\n" +
            "        padding: 14px 24px;\n" +
            "      }\n" +
            "\n" +
            "      /* Supporting marketing content */\n" +
            "      .marketing {\n" +
            "        margin: 60px 0;\n" +
            "      }\n" +
            "      .marketing p + h4 {\n" +
            "        margin-top: 28px;\n" +
            "      }\n" +
            "    </style>\n" +
            "<link href=\"../css/bootstrap-responsive.css\" rel=\"stylesheet\">\n" +
            "\n" +
            "<!--[if lt IE 9]>\n" +
            "      <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\n" +
            "    <![endif]-->\n" +
            "\n" +
            "</head>\n" +
            "<body>\n" +
            "<div class=\"container\">\n" +
            "<div class=\"masthead\">\n" +
            "<ul class=\"nav nav-pills pull-right\">\n" +
            "<li class=\"btn btn-small\"> <a href=\"/sandbox\" class=\"btn btn-small\">Home</a></li>\n" +
            "<li class=\"btn btn-small\"><a href=\"/sandbox/about\" class=\"btn btn-small\">About</a></li>\n" +
            "<li class=\"btn btn-small\"><a href=\"/sandbox/contact\" class=\"btn btn-small\"><b>Contact</b></a></li>\n" +
            "</ul>\n" +
            "<h3 class=\"muted\">Contact CloudCoin Consortium CloudBank Team</h3>\n" +
            "</div>\n" +
            "<hr>\n" +
            "<div class=\"jumbotron\">\n" +
            "<h1><a href=\"/cdn-cgi/l/email-protection\" class=\"__cf_email__\" data-cfemail=\"4f0c23203a2b0c2026210f1f3d203b2021222e2623612c2022\">[email&#160;protected]</a></h1>\n" +
            "</div>\n" +
            "<hr>\n" +
            "<h2>We would love to hear from you!</h2>\n" +
            "<br>\n" +
            "<hr>\n" +
            "<div class=\"footer\">\n" +
            "<p>&copy; Company 2017</p>\n" +
            "</div>\n" +
            "</div> \n" +
            "\n" +
            "\n" +
            "<script data-cfasync=\"false\" src=\"/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js\"></script></body>\n" +
            "</html>\n";

    public static final String htmlCashCheck = "\n" +
            "\n" +
            "\n" +
            "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "<meta charset=\"utf-8\">\n" +
            "<title>Template &middot; Bootstrap 2.2.2 Documentation - BootstrapDocs</title>\n" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "<meta name=\"description\" content=\"\">\n" +
            "<meta name=\"author\" content=\"\">\n" +
            "\n" +
            "<link href=\"../css/bootstrap2.css\" rel=\"stylesheet\">\n" +
            "<style type=\"text/css\">\n" +
            "      body {\n" +
            "        padding-top: 20px;\n" +
            "        padding-bottom: 40px;\n" +
            "      }\n" +
            "\n" +
            "      /* Custom container */\n" +
            "      .container-narrow {\n" +
            "        margin: 0 auto;\n" +
            "        max-width: 700px;\n" +
            "      }\n" +
            "      .container-narrow > hr {\n" +
            "        margin: 30px 0;\n" +
            "      }\n" +
            "\n" +
            "      /* Main marketing message and sign up button */\n" +
            "      .jumbotron {\n" +
            "        margin: 60px 0;\n" +
            "        text-align: center;\n" +
            "      }\n" +
            "      .jumbotron h1 {\n" +
            "        font-size: 72px;\n" +
            "        line-height: 1;\n" +
            "      }\n" +
            "      .jumbotron .btn {\n" +
            "        font-size: 21px;\n" +
            "        padding: 14px 24px;\n" +
            "      }\n" +
            "\n" +
            "      /* Supporting marketing content */\n" +
            "      .marketing {\n" +
            "        margin: 60px 0;\n" +
            "      }\n" +
            "      .marketing p + h4 {\n" +
            "        margin-top: 28px;\n" +
            "      }\n" +
            "    </style>\n" +
            "<link href=\"../css/bootstrap-responsive.css\" rel=\"stylesheet\">\n" +
            "\n" +
            "<!--[if lt IE 9]>\n" +
            "      <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\n" +
            "    <![endif]-->\n" +
            "\n" +
            "</head>\n" +
            "<body>\n" +
            "<div class=\"container-narrow\">\n" +
            "<div class=\"masthead\">\n" +
            "<ul class=\"nav nav-pills pull-right\">\n" +
            "<li class=\"active\"><a href=\"../sandbox/\">Home</a></li>\n" +
            "</ul>\n" +
            "<h3 class=\"muted\">Cash Check Test</h3>\n" +
            "</div>\n" +
            "<hr>\n" +
            "<div>\n" +
            "<p>Pres the button below to execute the following Get request</p>\n" +
            "<p>https://bank.cloudcoin.global/sandbox/check</p>\n" +
            "<div>\n" +
            "<form name=\"input\" action=\"/cash_check\" method=\"get\">\n" +
            "<br>\n" +
            "Check ID:\n" +
            "<br>\n" +
            "<input type=\"Text\" id=\"id\" size=\"50\" name=\"id\" value=\"\">\n" +
            "<br>\n" +
            "Sender ID:\n" +
            "<br>\n" +
            "<input type=\"Text\" id=\"acount\" size=\"50\" name=\"account\" value=\"\">\n" +
            "<br>\n" +
            "<br>\n" +
            "<input type=\"submit\" class=\"btn btn-large btn-success\" value=\"Submit\">\n" +
            "</form>\n" +
            "</div>\n" +
            "</div>\n" +
            "<hr>\n" +
            "<div style=\"background-color:WhiteSmoke; padding:30px; margin:20px;\">\n" +
            "<h4>Cash Check</h4>\n" +
            "<p>Cashes a check and sends you the cloud coins as a download</p>\n" +
            "<b>Sample request</b>\n" +
            "<pre>\t\t  \n" +
            "\thttps://bank.CloudCoin.Global/checks?id=a4b5e66f4b51418e81e8dc93e9db6503\n" +
            "\t\n" +
            "\t\t \n" +
            "\t </div>\n" +
            "\n" +
            "      <hr>\n" +
            "\n" +
            "     \n" +
            "\n" +
            "    </div> \n" +
            "\n" +
            "    \n" +
            "    \n" +
            "    \n" +
            "\n" +
            "  </body>\n" +
            "</html>\n";

    public static final String htmlDeposit = "\n" +
            "\n" +
            "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "<meta charset=\"utf-8\">\n" +
            "<title>Template &middot; Bootstrap 2.2.2 Documentation - BootstrapDocs</title>\n" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "<meta name=\"description\" content=\"\">\n" +
            "<meta name=\"author\" content=\"\">\n" +
            "<link href=\"../css/bootstrap2.css\" rel=\"stylesheet\">\n" +
            "\n" +
            "<style type=\"text/css\">\n" +
            "      body {\n" +
            "        padding-top: 20px;\n" +
            "        padding-bottom: 40px;\n" +
            "      }\n" +
            "\n" +
            "      /* Custom container */\n" +
            "      .container-narrow {\n" +
            "        margin: 0 auto;\n" +
            "        max-width: 700px;\n" +
            "      }\n" +
            "      .container-narrow > hr {\n" +
            "        margin: 30px 0;\n" +
            "      }\n" +
            "\n" +
            "      /* Main marketing message and sign up button */\n" +
            "      .jumbotron {\n" +
            "        margin: 60px 0;\n" +
            "        text-align: center;\n" +
            "      }\n" +
            "      .jumbotron h1 {\n" +
            "        font-size: 72px;\n" +
            "        line-height: 1;\n" +
            "      }\n" +
            "      .jumbotron .btn {\n" +
            "        font-size: 21px;\n" +
            "        padding: 14px 24px;\n" +
            "      }\n" +
            "\n" +
            "      /* Supporting marketing content */\n" +
            "      .marketing {\n" +
            "        margin: 60px 0;\n" +
            "      }\n" +
            "      .marketing p + h4 {\n" +
            "        margin-top: 28px;\n" +
            "      }\n" +
            "    </style>\n" +
            "\n" +
            "</head>\n" +
            "<body>\n" +
            "<div class=\"container-narrow\">\n" +
            "<div class=\"masthead\">\n" +
            "<ul class=\"nav nav-pills pull-right\">\n" +
            "<li class=\"active\"><a href=\"/sandbox\">Home</a></li>\n" +
            "</ul>\n" +
            "<h1 class=\"muted\">Deposit One Stack Service</h1>\n" +
            "<h3 class=\"muted\">Test Deposit One Stack Service</h3>\n" +
            "</div>\n" +
            "<hr>\n" +
            "<div id=\"page-wrapper\">\n" +
            "<h3>Deposit One Stack File</h3>\n" +
            "<p>Allows you to upload a stack of CloudCoins into your bank. You must know your account and PK.</p>\n" +
            "<form method=\"GET\" action=\"/deposit_one_stack\">\n" +
            "<input type=\"hidden\" id=\"stack\" name=\"stack\">\n" +
            "\n" +
            "<div>\n" +
            "Account: <br>\n"+
            "<input type=\"text\" id=\"account\" size=\"50\" name=\"account\"><br>\n" +
            "Private Key: <br>\n"+
            "<input type=\"text\" id=\"PrivateKey\" size=\"50\" name=\"pk\"><br><br>\n" +
            "</div>\n" +
            "<div>\n" +
            "<br>\n" +
            "</div>\n" +
            "<div>\n" +
            "<br>\n" +
            "Select a text file:\n" +
            "<input type=\"file\" id=\"fileInput\"><br><br>\n" +
            "</div>\n" +
            "<button class=\"btn btn-large btn-success\">GET Stack (after you choose File)</button>\n" +
            "</form>\n" +
            "\n" +
            "<pre id=\"fileDisplayArea\"><pre>\t\t\n" +
            "\t\t\n" +
            "\n" +
            "\t</div>\n" +
            "\t  \n" +
            "\t  \n" +
            "\t  \n" +
            "\t  <script>\n" +
            "\t  \n" +
            "\t  \n" +
            "\t  window.onload = function() {\n" +
            "\t\tvar fileInput = document.getElementById('fileInput');\n" +
            "\t\tvar fileDisplayArea = document.getElementById('fileDisplayArea');\n" +
            "\n" +
            "\t\tfileInput.addEventListener('change', function(e) {\n" +
            "\t\t\tvar file = fileInput.files[0];\n" +
            "\t\t\t//var textType = ([a-zA-Z0-9\\s_\\\\.\\-:])+(.stack)$ );\n" +
            "\n" +
            "\t\t//\tif (file.type.match(textType)) {\n" +
            "\t\t\t\tvar reader = new FileReader();\n" +
            "\n" +
            "\t\t\t\treader.onload = function(e) {\n" +
            "\t\t\t\t\tfileDisplayArea.innerText = reader.result;\n" +
            "\t\t\t\t\tvar str = reader.result;\n" +
            "\t\t\t\t\tstr.replace(/\\s/g, '');\n" +
            "\t\t\t\t\tstr = str.replace(/[^\\x20-\\x7E]/gmi, \"\");\n" +
            "\t\t\t\t\tstack.value = str;\n" +
            "\t\t\t\t}\n" +
            "\n" +
            "\t\t\t\treader.readAsText(file);\t\n" +
            "\t\t\t//} else {\n" +
            "\t\t\t//\tfileDisplayArea.innerText = \"File not supported!\"\n" +
            "\t\t\t//}\n" +
            "\t\t});\n" +
            "}\n" +
            "\n" +
            "\t  \n" +
            "\t  </script>\n" +
            "\t  \n" +
            "\t  \n" +
            "\t  \n" +
            "\t  <hr>\n" +
            "\t  \n" +
            "\t\n" +
            " \t \n" +
            "<div style=\"background-color:LightSkyBlue; padding:30px; margin:20px;\">\t\t  \n" +
            "          <h4>public deposit_one_stack</h4>\n" +
            "           <p>The program must put a stack file in a folder that is accessible via the web to cors on the CloudBank Server. </p>\n" +
            "\t\t  \n" +
            "\t\t  <b>Sample GET Request:</b>\n" +
            "\t\t  <pre>\t\t<span id=\"url\">  \n" +
            "\thttps://bank.cloudcoin.global//deposit_one_stack/?</span>\n" +
            "stack=\n" +
            "{\n" +
            "\t\"cloudcoin\": [\n" +
            "\t{ \n" +
            "\t\"nn\":\"1\", \n" +
            "\t\"sn\":\"1112240\", \n" +
            "\t\"an\": [\"f5a52ee881daaae548c24a8eaff7176c\", \"415c2375a6fa48c4661f5af8d7c95541\", \n" +
            "\t\t\"73e067b7b47c1556deebdca33f9a09fb\", \"9b90d265d102a565a702813fa2211f54\", \n" +
            "\t\t\"e3e191ca987c8010a3adc49c6fc18417\", \"baa7578e207b7cfaa0b8336d7ed4a4f8\", \n" +
            "\t\t\"6d8a5c66a589532fe9e5dc3932650cfa\", \"1170b354e097f2d90132869631409bd3\", \n" +
            "\t\t\"b7bc83e8ee7529ff9f874866b901cf15\", \"a37f6c4af8fbcfbc4d77880fc29ddfbc\",\n" +
            "\t\t\"277668208e9bafd9393aebd36945a2c3\", \"ef50088c8218afe53ce2ecd655c2c786\", \n" +
            "\t\t\"b7bbb01fbe6c3a830a17bd9a842b46c0\", \"737360e18596d74d784f563ca729aaea\", \n" +
            "\t\t\"e054a34f2790fd3353ea26e5d92d9d2f\", \"7051afef36dc388e65e982bc853be417\", \n" +
            "\t\t\"ea22cbae0394f6c6918691f2e2f2e267\", \"95d1278f54b5daca5898c62f267b6364\", \n" +
            "\t\t\"b98560e11b7142d1addf5b9cf32898da\", \"e325f615f93ed682c7aadf6b2d77c17a\",\n" +
            "\t\t\"3e8f9d74290fe31d416b90db3a0d2ab1\", \"c92d1656ded0a4f68e5171c8331e0aea\", \n" +
            "\t\t\"7a9cee66544934965bca0c0cb582ba73\", \"7a55437fa98c1b10d7f47d84f9accdf0\", \n" +
            "\t\t\"c3577cced2d428f205355522bc1119b6\"],\n" +
            "\t\"ed\":\"7-2019\",\n" +
            "\t\"pown\":\"ppppppppppppppppppppppppp\",\n" +
            "\t\"aoid\": []\n" +
            "\t}\n" +
            "\n" +
            "\t]\n" +
            "}\n" +
            "\t\t  \n" +
            "\t\t  </pre>\n" +
            "\t\t  <b>Sample Response if good:</b>\n" +
            "\t\t  <pre>{\n" +
            " \"bank_server\":\"bank.cloudcoin.global\",\n" +
            " \"status\":\"importing\",\n" +
            " \"message\":\"The stack file has been imported and detection will begin automatically so long as they are not already in bank. \n" +
            "  Please check your reciept.\",\n" +
            " \"reciept\":\"640322f6d30c45328914b441ac0f4e5b\",\n" +
            " \"time\":\"2016-49-21 7:49:PM\"\n" +
            "}\n" +
            "\t\t\t\t\n" +
            "\t\t  </pre>\n" +
            "\t\t  <b>Sample Response if bad file bad:</b>\n" +
            "\t\t  <pre>{\n" +
            " \"bank_server\":\"bank.cloudcoin.global\",\n" +
            " \"status\":\"error\",\n" +
            " \"message\":\"JSON: Your stack file was corrupted. Please check JSON validation.\",\n" +
            " \"reciept\":\"640322f6d30c45328914b441ac0f4e5b\",\n" +
            " \"time\":\"2016-49-21 7:49:PM\"\n" +
            "}\n" +
            "\t\t\t\t\n" +
            "\t\t  </pre>\n" +
            "\t\t  \t\t  <b>Sample Response if nothing attached:</b>\n" +
            "\t\t  <pre>{\n" +
            " \"bank_server\":\"bank.cloudcoin.global\",\n" +
            " \"status\":\"error\",\n" +
            " \"message\":\"LoadFile: The stack file was empty.\",\n" +
            " \"reciept\":\"640322f6d30c45328914b441ac0f4e5b\",\n" +
            " \"time\":\"2016-49-21 7:49:PM\"\n" +
            "}\n" +
            "\t\t\t\t\n" +
            "\t\t  </pre>\n" +
            "\t\t\n" +
            "        </div>\n" +
            " </div>\n" +
            "\n" +
            "    </div> \n" +
            "\t<script>\n" +
            "\t\tvar CurrentUrl=window.location.host + \"//deposit_one_stack\" ;\n" +
            "\t\tdocument.getElementById(\"url\").innerHTML=CurrentUrl;\n" +
            "</script   \n" +
            "   <!-- Le javascript\n" +
            "    ================================================== -->\n" +
            "    \n" +
            "\n" +
            "  </body>\n" +
            "</html>\n";

    public static final String htmlDepositGetChange = "\n" +
            "\n" +
            "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "<meta charset=\"utf-8\">\n" +
            "<title>Template &middot; Bootstrap 2.2.2 Documentation - BootstrapDocs</title>\n" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "<meta name=\"description\" content=\"\">\n" +
            "<meta name=\"author\" content=\"\">\n" +
            "<link href=\"../css/bootstrap2.css\" rel=\"stylesheet\">\n" +
            "\n" +
            "<style type=\"text/css\">\n" +
            "      body {\n" +
            "        padding-top: 20px;\n" +
            "        padding-bottom: 40px;\n" +
            "      }\n" +
            "\n" +
            "      /* Custom container */\n" +
            "      .container-narrow {\n" +
            "        margin: 0 auto;\n" +
            "        max-width: 700px;\n" +
            "      }\n" +
            "      .container-narrow > hr {\n" +
            "        margin: 30px 0;\n" +
            "      }\n" +
            "\n" +
            "      /* Main marketing message and sign up button */\n" +
            "      .jumbotron {\n" +
            "        margin: 60px 0;\n" +
            "        text-align: center;\n" +
            "      }\n" +
            "      .jumbotron h1 {\n" +
            "        font-size: 72px;\n" +
            "        line-height: 1;\n" +
            "      }\n" +
            "      .jumbotron .btn {\n" +
            "        font-size: 21px;\n" +
            "        padding: 14px 24px;\n" +
            "      }\n" +
            "\n" +
            "      /* Supporting marketing content */\n" +
            "      .marketing {\n" +
            "        margin: 60px 0;\n" +
            "      }\n" +
            "      .marketing p + h4 {\n" +
            "        margin-top: 28px;\n" +
            "      }\n" +
            "    </style>\n" +
            "\n" +
            "</head>\n" +
            "<body>\n" +
            "<div class=\"container-narrow\">\n" +
            "<div class=\"masthead\">\n" +
            "<ul class=\"nav nav-pills pull-right\">\n" +
            "<li class=\"active\"><a href=\"/sandbox\">Home</a></li>\n" +
            "</ul>\n" +
            "<h1 class=\"muted\">Deposit With Change Service</h1>\n" +
            "<h3 class=\"muted\">Test Deposit With Change Service</h3>\n" +
            "</div>\n" +
            "<hr>\n" +
            "<div id=\"page-wrapper\">\n" +
            "<h3>Deposit With Change File</h3>\n" +
            "<p>Allows you to upload a stack of CloudCoins into your bank. You must know your account and PK.</p>\n" +
            "<form method=\"GET\" action=\"/deposit_with_change\">\n" +
            "<input type=\"hidden\" id=\"stack\" name=\"stack\">\n" +
            "\n" +
            "<div>\n" +
            "Account: <br>\n"+
            "<input name=\"account\"><br>\n"+
            "Private Key: <br>\n"+
            "<input name=\"pk\"><br><br>\n"+
            "Amount:<br>\n" +
            "<input type=\"text\" id=\"amount\" size=\"50\" name=\"amount\">\n" +
            "</div>\n" +
            "<div>\n" +
            "<br>\n" +
            "</div>\n" +
            "<div>\n" +
            "<br>\n" +
            "Select a text file:\n" +
            "<input type=\"file\" id=\"fileInput\"><br><br>\n" +
            "</div>\n" +
            "<button class=\"btn btn-large btn-success\">GET Stack (after you choose File)</button>\n" +
            "</form>\n" +
            "\n" +
            "<pre id=\"fileDisplayArea\"><pre>\t\t\n" +
            "\t\t\n" +
            "\n" +
            "\t</div>\n" +
            "\t  \n" +
            "\t  \n" +
            "\t  \n" +
            "\t  <script>\n" +
            "\t  \n" +
            "\t  \n" +
            "\t  window.onload = function() {\n" +
            "\t\tvar fileInput = document.getElementById('fileInput');\n" +
            "\t\tvar fileDisplayArea = document.getElementById('fileDisplayArea');\n" +
            "\n" +
            "\t\tfileInput.addEventListener('change', function(e) {\n" +
            "\t\t\tvar file = fileInput.files[0];\n" +
            "\t\t\t//var textType = ([a-zA-Z0-9\\s_\\\\.\\-:])+(.stack)$ );\n" +
            "\n" +
            "\t\t//\tif (file.type.match(textType)) {\n" +
            "\t\t\t\tvar reader = new FileReader();\n" +
            "\n" +
            "\t\t\t\treader.onload = function(e) {\n" +
            "\t\t\t\t\tfileDisplayArea.innerText = reader.result;\n" +
            "\t\t\t\t\tvar str = reader.result;\n" +
            "\t\t\t\t\tstr.replace(/\\s/g, '');\n" +
            "\t\t\t\t\tstr = str.replace(/[^\\x20-\\x7E]/gmi, \"\");\n" +
            "\t\t\t\t\tstack.value = str;\n" +
            "\t\t\t\t}\n" +
            "\n" +
            "\t\t\t\treader.readAsText(file);\t\n" +
            "\t\t\t//} else {\n" +
            "\t\t\t//\tfileDisplayArea.innerText = \"File not supported!\"\n" +
            "\t\t\t//}\n" +
            "\t\t});\n" +
            "}\n" +
            "\n" +
            "\t  \n" +
            "\t  </script>\n" +
            "\t  \n" +
            "\t  \n" +
            "\t  \n" +
            "\t  <hr>\n" +
            "\t  \n" +
            "\t\n" +
            " \t \n" +
            "<div style=\"background-color:LightSkyBlue; padding:30px; margin:20px;\">\t\t  \n" +
            "          <h4>public deposit_one_stack</h4>\n" +
            "           <p>The program must put a stack file in a folder that is accessible via the web to cors on the CloudBank Server. </p>\n" +
            "\t\t  \n" +
            "\t\t  <b>Sample GET Request:</b>\n" +
            "\t\t  <pre>\t\t<span id=\"url\">  \n" +
            "\thttps://bank.cloudcoin.global//deposit_one_stack/?</span>\n" +
            "stack=\n" +
            "{\n" +
            "\t\"cloudcoin\": [\n" +
            "\t{ \n" +
            "\t\"nn\":\"1\", \n" +
            "\t\"sn\":\"1112240\", \n" +
            "\t\"an\": [\"f5a52ee881daaae548c24a8eaff7176c\", \"415c2375a6fa48c4661f5af8d7c95541\", \n" +
            "\t\t\"73e067b7b47c1556deebdca33f9a09fb\", \"9b90d265d102a565a702813fa2211f54\", \n" +
            "\t\t\"e3e191ca987c8010a3adc49c6fc18417\", \"baa7578e207b7cfaa0b8336d7ed4a4f8\", \n" +
            "\t\t\"6d8a5c66a589532fe9e5dc3932650cfa\", \"1170b354e097f2d90132869631409bd3\", \n" +
            "\t\t\"b7bc83e8ee7529ff9f874866b901cf15\", \"a37f6c4af8fbcfbc4d77880fc29ddfbc\",\n" +
            "\t\t\"277668208e9bafd9393aebd36945a2c3\", \"ef50088c8218afe53ce2ecd655c2c786\", \n" +
            "\t\t\"b7bbb01fbe6c3a830a17bd9a842b46c0\", \"737360e18596d74d784f563ca729aaea\", \n" +
            "\t\t\"e054a34f2790fd3353ea26e5d92d9d2f\", \"7051afef36dc388e65e982bc853be417\", \n" +
            "\t\t\"ea22cbae0394f6c6918691f2e2f2e267\", \"95d1278f54b5daca5898c62f267b6364\", \n" +
            "\t\t\"b98560e11b7142d1addf5b9cf32898da\", \"e325f615f93ed682c7aadf6b2d77c17a\",\n" +
            "\t\t\"3e8f9d74290fe31d416b90db3a0d2ab1\", \"c92d1656ded0a4f68e5171c8331e0aea\", \n" +
            "\t\t\"7a9cee66544934965bca0c0cb582ba73\", \"7a55437fa98c1b10d7f47d84f9accdf0\", \n" +
            "\t\t\"c3577cced2d428f205355522bc1119b6\"],\n" +
            "\t\"ed\":\"7-2019\",\n" +
            "\t\"pown\":\"ppppppppppppppppppppppppp\",\n" +
            "\t\"aoid\": []\n" +
            "\t}\n" +
            "\n" +
            "\t]\n" +
            "}\n" +
            "\t\t  \n" +
            "\t\t  </pre>\n" +
            "\t\t  <b>Sample Response if good:</b>\n" +
            "\t\t  <pre>{\n" +
            " \"bank_server\":\"bank.cloudcoin.global\",\n" +
            " \"status\":\"importing\",\n" +
            " \"message\":\"The stack file has been imported and detection will begin automatically so long as they are not already in bank. \n" +
            "  Please check your reciept.\",\n" +
            " \"reciept\":\"640322f6d30c45328914b441ac0f4e5b\",\n" +
            " \"time\":\"2016-49-21 7:49:PM\"\n" +
            "}\n" +
            "\t\t\t\t\n" +
            "\t\t  </pre>\n" +
            "\t\t  <b>Sample Response if bad file bad:</b>\n" +
            "\t\t  <pre>{\n" +
            " \"bank_server\":\"bank.cloudcoin.global\",\n" +
            " \"status\":\"error\",\n" +
            " \"message\":\"JSON: Your stack file was corrupted. Please check JSON validation.\",\n" +
            " \"reciept\":\"640322f6d30c45328914b441ac0f4e5b\",\n" +
            " \"time\":\"2016-49-21 7:49:PM\"\n" +
            "}\n" +
            "\t\t\t\t\n" +
            "\t\t  </pre>\n" +
            "\t\t  \t\t  <b>Sample Response if nothing attached:</b>\n" +
            "\t\t  <pre>{\n" +
            " \"bank_server\":\"bank.cloudcoin.global\",\n" +
            " \"status\":\"error\",\n" +
            " \"message\":\"LoadFile: The stack file was empty.\",\n" +
            " \"reciept\":\"640322f6d30c45328914b441ac0f4e5b\",\n" +
            " \"time\":\"2016-49-21 7:49:PM\"\n" +
            "}\n" +
            "\t\t\t\t\n" +
            "\t\t  </pre>\n" +
            "\t\t\n" +
            "        </div>\n" +
            " </div>\n" +
            "\n" +
            "    </div> \n" +
            "\t<script>\n" +
            "\t\tvar CurrentUrl=window.location.host + \"//deposit_one_stack\" ;\n" +
            "\t\tdocument.getElementById(\"url\").innerHTML=CurrentUrl;\n" +
            "</script   \n" +
            "   <!-- Le javascript\n" +
            "    ================================================== -->\n" +
            "    \n" +
            "\n" +
            "  </body>\n" +
            "</html>\n";

    public static final String htmlEcho = "<!DOCTYPE html>\n"+
            "<html lang=\"en\">\n"+
            "<head>\n"+
            "<meta charset=\"utf-8\">\n"+
            "<title>Test Echo on CloudServer</title>\n"+
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"+
            "<meta name=\"description\" content=\"\">\n"+
            "<meta name=\"author\" content=\"\">\n"+
            "\n"+
            "<link href=\"../css/bootstrap2.css\" rel=\"stylesheet\">\n"+
            "<style type=\"text/css\">\n"+
            "      body {\n"+
            "        padding-top: 20px;\n"+
            "        padding-bottom: 40px;\n"+
            "      }\n"+
            "      /* Custom container */\n"+
            "      .container-narrow {\n"+
            "        margin: 0 auto;\n"+
            "        max-width: 700px;\n"+
            "      }\n"+
            "      .container-narrow > hr {\n"+
            "        margin: 30px 0;\n"+
            "      }\n"+
            "      /* Main marketing message and sign up button */\n"+
            "      .jumbotron {\n"+
            "        margin: 60px 0;\n"+
            "        text-align: center;\n"+
            "      }\n"+
            "      .jumbotron h1 {\n"+
            "        font-size: 72px;\n"+
            "        line-height: 1;\n"+
            "      }\n"+
            "      .jumbotron .btn {\n"+
            "        font-size: 21px;\n"+
            "        padding: 14px 24px;\n"+
            "      }\n"+
            "      /* Supporting marketing content */\n"+
            "      .marketing {\n"+
            "        margin: 60px 0;\n"+
            "      }\n"+
            "      .marketing p + h4 {\n"+
            "        margin-top: 28px;\n"+
            "      }\n"+
            "    </style>\n"+
            "<link href=\"../css/bootstrap-responsive.css\" rel=\"stylesheet\">\n"+
            "\n"+
            "<!--[if lt IE 9]>\n"+
            "      <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\n"+
            "    <![endif]-->\n"+
            "\n"+
            "</head>\n"+
            "<body>\n"+
            "<div class=\"container-narrow\">\n"+
            "<div class=\"masthead\">\n"+
            "<ul class=\"nav nav-pills pull-right\">\n"+
            "<li class=\"active\"><a href=\"../sandbox\">Home</a></li>\n"+
            "</ul>\n"+
            "<h1 class=\"muted\">Echo</h1>\n"+
            "<h3 class=\"muted\">Test Echo Service</h3>\n"+
            "</div>\n"+
            "<hr>\n"+
            "<div class=\"jumbotron\">\n"+
            "<p>Pres the button below to execute the following GET request</p>\n"+
            "<p><span id = url></span></p>\n"+
            "<form action=\"/echo\" method=\"GET\">\n"+
            "Account: <br>\n"+
            "<input name=\"account\"><br>\n"+
            "Private Key: <br>\n"+
            "<input name=\"pk\"><br><br>\n"+
            "<input type=\"submit\" class=\"btn btn-large btn-success\" value=\"GET /echo\">\n"+
            "</form>\n"+
            "</div>\n"+
            "<hr>\n"+
            "<div style=\"background-color:WhiteSmoke; padding:30px; margin:20px;\">\n"+
            "<h4>private echo</h4>\n"+
            "<p>Tells the CloudBank server to echo the RAIDA to see if it has connectivity. </p>\n"+
            "<b>Sample request</b>\n"+
            "<pre id=url2>\t\t  \n"+
            "\thttps://bank.cloudcoin.global/echo\n"+
            "\t\t  \n"+
            "\t\t  </pre>\n"+
            "<b>Sample response if the RAIDA is ready:</b>\n"+
            "<pre>{\n"+
            "\t\"bank_server\":\"Bank.CloudCoin.Global\",\n"+
            "\t\"status\":\"ready\",\n"+
            "\t\"version\":\"2.0\",\n"+
            "\t\"message\":\"The RAIDA is ready for counterfeit detection.\",\n"+
            "\t\"time\":\"2018-06-23T05:18:34.3025868Z\",\n"+
            "\t\"readyCount\":25,\n"+
            "\t\"notReadyCount\":0\n"+
            "}\n"+
            "\t\t\t\t\n"+
            "\t\t  </pre>\n"+
            "<b>Sample response if the RAIDA is not ready.</b>\n"+
            "Meaning not enough RAIDA servers can be contacted to import new coins.\n"+
            "<pre>{\n"+
            "\t\"bank_server\":\"Bank.CloudCoin.Global\",\n"+
            "\t\"status\":\"fail\",\n"+
            "\t\"version\":\"2.0\",\n"+
            "\t\"message\":\"Not enough RAIDA servers can be contacted to import new coins.\",\n"+
            "\t\"time\":\"2018-06-23T05:18:34.3025868Z\",\n"+
            "\t\"readyCount\":2,\n"+
            "\t\"notReadyCount\":23\n"+
            "}\n"+
            "\n"+
            "\t\t\t\t\n"+
            "\t\t  </pre>\n"+
            "</div>\n"+
            "<hr>\n"+
            "</div> \n"+
            "<script>\n"+
            "\t\n"+
            "\t\tvar CurrentUrl=window.location.host ;\n"+
            "\t\tdocument.getElementById(\"url\").innerHTML=CurrentUrl+\"/echo?account=CloudCoin@Protonmail.com&pk=640322f6d30c45328914b441ac0f4e5b\";\n"+
            "\tdocument.getElementById(\"url2\").innerHTML=\"<BR>\"+CurrentUrl+\"/echo?account=CloudCoin@Protonmail.com&pk=640322f6d30c45328914b441ac0f4e5b<BR><BR>\";\n"+
            "\t\t</script>\n"+
            "\n"+
            "\n"+
            "</body>\n"+
            "</html>";

    public static final String htmlGetReceipt = "\n" +
            "\n" +
            "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "<meta charset=\"utf-8\">\n" +
            "<title>Get Receipt</title>\n" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "<meta name=\"description\" content=\"\">\n" +
            "<meta name=\"author\" content=\"\">\n" +
            "\n" +
            "<link href=\"../css/bootstrap2.css\" rel=\"stylesheet\">\n" +
            "<style type=\"text/css\">\n" +
            "      body {\n" +
            "        padding-top: 20px;\n" +
            "        padding-bottom: 40px;\n" +
            "      }\n" +
            "\n" +
            "      /* Custom container */\n" +
            "      .container-narrow {\n" +
            "        margin: 0 auto;\n" +
            "        max-width: 700px;\n" +
            "      }\n" +
            "      .container-narrow > hr {\n" +
            "        margin: 30px 0;\n" +
            "      }\n" +
            "\n" +
            "      /* Main marketing message and sign up button */\n" +
            "      .jumbotron {\n" +
            "        margin: 60px 0;\n" +
            "        text-align: center;\n" +
            "      }\n" +
            "      .jumbotron h1 {\n" +
            "        font-size: 72px;\n" +
            "        line-height: 1;\n" +
            "      }\n" +
            "      .jumbotron .btn {\n" +
            "        font-size: 21px;\n" +
            "        padding: 14px 24px;\n" +
            "      }\n" +
            "\n" +
            "      /* Supporting marketing content */\n" +
            "      .marketing {\n" +
            "        margin: 60px 0;\n" +
            "      }\n" +
            "      .marketing p + h4 {\n" +
            "        margin-top: 28px;\n" +
            "      }\n" +
            "    </style>\n" +
            "\n" +
            "<!--[if lt IE 9]>\n" +
            "      <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\n" +
            "    <![endif]-->\n" +
            "\n" +
            "</head>\n" +
            "<body>\n" +
            "<div class=\"container-narrow\">\n" +
            "<div class=\"masthead\">\n" +
            "<ul class=\"nav nav-pills pull-right\">\n" +
            "<li class=\"active\"><a href=\"/sandbox\">Home</a></li>\n" +
            "</ul>\n" +
            "<h1 class=\"muted\">Receipt</h1>\n" +
            "<h3 class=\"muted\">Get Receipt Test</h3>\n" +
            "</div>\n" +
            "https://<span id=\"url\">bank.cloudcoin.global</span>/ge<a href=\"/cdn-cgi/l/email-protection\" class=\"__cf_email__\" data-cfemail=\"166249647375737f66622964782b73702326262e2e752e24272e7770732325757324737572202323752475212e2030777575796378622b557a79637255797f7856\">[email&#160;protected]</a>protonmai.com\n" +
            "<hr>\n" +
            "<div>\n" +
            "<form name=\"input\" action=\"/get_receipt\" method=\"GET\">\n" +
            "<br>\n" +
            "Receipt Number:\n" +
            "<br>\n" +
            "<input type=\"Text\" id=\"rn\" size=\"50\" name=\"rn\" value=\"\">\n" +
            "<br>\n" +
            "Account ID:\n" +
            "<br>\n" +
            "<input type=\"Text\" id=\"account\" size=\"50\" name=\"account\" value=\"\">\n" +
            "<br>\n" +
            "<br>\n" +
            "<input type=\"submit\" class=\"btn btn-large btn-success\" value=\"Get Receipt\">\n" +
            "</div>\n" +
            "\n" +
            "<hr>\n" +
            "<div style=\"background-color:LightGoldenRodYellow; padding:30px; margin:20px;\">\n" +
            "<h4>public get_receipt</h4>\n" +
            "<p>Asks the CloudBank to send it a receipt to see what coins where authenticated.</p>\n" +
            "<b>Sample GET Request:</b>\n" +
            "<pre>\t\t  \n" +
            "\thttps://<span id=\"url2\">bank.cloudcoin.global</span>/ge<a href=\"/cdn-cgi/l/email-protection\" class=\"__cf_email__\" data-cfemail=\"dbaf84a9beb8beb2abafe4a9b5e6bebdeeebebe3e3b8e3e9eae3babdbeeee8b8bee9beb8bfedeeeeb8e9b8ece3edfdbab8b8b4aeb5afe698b7b4aebf98b4b2b59b\">[email&#160;protected]</a>protonmai.com\n" +
            "\n" +
            "\t\t  </pre>\n" +
            "<b>Sample response if good</b> If powning process has not been started\n" +
            "<pre>{\n" +
            "\t\"receipt_id\": \"e054a34f2790fd3353ea26e5d92d9d2f\",\n" +
            "\t\"time\": \"2016-49-21 7:49:PM\",\n" +
            "\t\"timezone\": \"UTC-7\",\n" +
            "\t\"bank_server\": \"ccc.cloudcoin.global\",\n" +
            "\t\"total_authentic\": 5,\n" +
            "\t\"total_fracked\": 7,\n" +
            "\t\"total_counterfeit\": 1,\n" +
            "\t\"total_lost\": 0,\n" +
            "\t\"receipt_detail\": [{\n" +
            "\t\t\t\"nn.sn\": \"1.16777216\",\n" +
            "\t\t\t\"status\": \"suspect\",\n" +
            "\t\t\t\"pown\": \"uuuuuuuuuuuuuuuuuuuuuuuuu\",\n" +
            "\t\t\t\"note\": \"Waiting\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"nn.sn\": \"1:1425632\",\n" +
            "\t\t\t\"status\": \"suspect\",\n" +
            "\t\t\t\"pown\": \"uuuuuuuuuuuuuuuuuuuuuuuuu\",\n" +
            "\t\t\t\"note\": \"Waiting\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"nn.sn\": \"1.956258\",\n" +
            "\t\t\t\"status\": \"suspect\",\n" +
            "\t\t\t\"pown\": \"uuuuuuuuuuuuuuuuuuuuuuuuu\",\n" +
            "\t\t\t\"note\": \"Waiting\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"nn.sn\": \"1.15666214\",\n" +
            "\t\t\t\"status\": \"suspect\",\n" +
            "\t\t\t\"pown\": \"uuuuuuuuuuuuuuuuuuuuuuuuu\",\n" +
            "\t\t\t\"note\": \"Waiting\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"nn.sn\": \"1.15265894\",\n" +
            "\t\t\t\"status\": \"suspect\",\n" +
            "\t\t\t\"pown\": \"uuuuuuuuuuuuuuuuuuuuuuuuu\",\n" +
            "\t\t\t\"note\": \"Waiting\"\n" +
            "\t\t}\n" +
            "\n" +
            "\t]\n" +
            "\n" +
            "}\n" +
            "\t\t\t\t\n" +
            "\t\t  </pre>\n" +
            "<b>Sample response if good</b> If powning process is complete:\n" +
            "<pre>\t\t  \n" +
            "{\n" +
            "        \"receipt_id\":\"e054a34f2790fd3353ea26e5d92d9d2f\",\n" +
            "\t\"time\": \"2016-49-21 7:49:PM\",\n" +
            "\t\"timezone\": \"UTC-7\",\n" +
            "\t\"bank_server\": \"ccc.cloudcoin.global\",\n" +
            "\t\"total_authentic\": 5,\n" +
            "\t\"total_fracked\": 7,\n" +
            "\t\"total_counterfeit\": 1,\n" +
            "\t\"total_lost\": 0,\n" +
            "\t\"receipt_detail\": [{\n" +
            "\t\t\t\"nn.sn\": \"1.16777216\",\n" +
            "\t\t\t\"status\": \"authentic\",\n" +
            "\t\t\t\"pown\": \"ppppppppepppppppppppeppp\",\n" +
            "\t\t\t\"note\": \"Moved to Bank\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"nn.sn\": \"1:1425632\",\n" +
            "\t\t\t\"status\": \"counterfeit\",\n" +
            "\t\t\t\"pown\": \"fffffffffpfffffffffffffff\",\n" +
            "\t\t\t\"note\": \"Sent to trash\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"nn.sn\": \"1.956258\",\n" +
            "\t\t\t\"status\": \"authentic\",\n" +
            "\t\t\t\"pown\": \"ppppppppppppppppppppppppf\",\n" +
            "\t\t\t\"note\": \"Moved to Fracked\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"nn.sn\": \"1.15666214\",\n" +
            "\t\t\t\"status\": \"lost\",\n" +
            "\t\t\t\"pown\": \"pfpfpfpfpfpfpfpfpfpfpfpfp\",\n" +
            "\t\t\t\"note\": \"Moved to Lost\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"nn.sn\": \"1.15265894\",\n" +
            "\t\t\t\"status\": \"lost\",\n" +
            "\t\t\t\"pown\": \"ppppffpeepfpppfpfffpfffpf\",\n" +
            "\t\t\t\"note\": \"STRINGS ATTACHED!\"\n" +
            "\t\t}\n" +
            "\n" +
            "\t]\n" +
            "\n" +
            "}\n" +
            "\t\t  </pre>\n" +
            "</div>\n" +
            "<hr>\n" +
            "</div> \n" +
            "\n" +
            "\n" +
            "<script data-cfasync=\"false\" src=\"/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js\"></script><script>\n" +
            "\t\n" +
            "\t\tvar CurrentUrl=window.location.host ;\n" +
            "\t\tdocument.getElementById(\"url\").innerHTML=CurrentUrl;\n" +
            "\t\tdocument.getElementById(\"url2\").innerHTML=\"<BR>\"+CurrentUrl;\n" +
            "\t</script>\n" +
            "</body>\n" +
            "</html>\n";

    public static final String htmlMarkForSale = "\n" +
            "\n" +
            "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "<meta charset=\"utf-8\">\n" +
            "<title>Test Mark Coins For Sale</title>\n" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "<meta name=\"description\" content=\"\">\n" +
            "<meta name=\"author\" content=\"\">\n" +
            "\n" +
            "<link href=\"../css/bootstrap2.css\" rel=\"stylesheet\">\n" +
            "<style type=\"text/css\">\n" +
            "      body {\n" +
            "        padding-top: 20px;\n" +
            "        padding-bottom: 40px;\n" +
            "      }\n" +
            "\n" +
            "      /* Custom container */\n" +
            "      .container-narrow {\n" +
            "        margin: 0 auto;\n" +
            "        max-width: 700px;\n" +
            "      }\n" +
            "      .container-narrow > hr {\n" +
            "        margin: 30px 0;\n" +
            "      }\n" +
            "\n" +
            "      /* Main marketing message and sign up button */\n" +
            "      .jumbotron {\n" +
            "        margin: 60px 0;\n" +
            "        text-align: center;\n" +
            "      }\n" +
            "      .jumbotron h1 {\n" +
            "        font-size: 72px;\n" +
            "        line-height: 1;\n" +
            "      }\n" +
            "      .jumbotron .btn {\n" +
            "        font-size: 21px;\n" +
            "        padding: 14px 24px;\n" +
            "      }\n" +
            "\n" +
            "      /* Supporting marketing content */\n" +
            "      .marketing {\n" +
            "        margin: 60px 0;\n" +
            "      }\n" +
            "      .marketing p + h4 {\n" +
            "        margin-top: 28px;\n" +
            "      }\n" +
            "    </style>\n" +
            "<link href=\"../css/bootstrap-responsive.css\" rel=\"stylesheet\">\n" +
            "\n" +
            "<!--[if lt IE 9]>\n" +
            "      <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\n" +
            "    <![endif]-->\n" +
            "\n" +
            "</head>\n" +
            "<body>\n" +
            "<div class=\"container-narrow\">\n" +
            "<div class=\"masthead\">\n" +
            "<ul class=\"nav nav-pills pull-right\">\n" +
            "<li class=\"active\"><a href=\"/sandbox\">Home</a></li>\n" +
            "</ul>\n" +
            "<h1 class=\"muted\">Mark For Sale Service</h1>\n" +
            "<h3 class=\"muted\">Test Mark For Sale Service</h3>\n" +
            "</div>\n" +
            "<hr>\n" +
            "<div id=\"page-wrapper\">\n" +
            "<h3>Mark For Sale File</h3>\n" +
            "<p>Allows you to mark any number of CloudCoins for sale. You must know your account and PK.</p>\n" +
            "<form method=\"GET\" action=\"/mark_for_sale\">\n" +
            "<div>\n" +
            "Account: <br>\n"+
            "<input type=\"text\" id=\"account\" size=\"50\" name=\"account\"><br>\n" +
            "Private Key: <br>\n"+
            "<input type=\"text\" id=\"PrivateKey\" size=\"50\" name=\"pk\"><br><br>\n" +
            "Ones: <br>\n"+
            "<input type=\"text\" id=\"ones\" size=\"50\" name=\"ones\"><br>\n" +
            "Fives: <br>\n"+
            "<input type=\"text\" id=\"fives\" size=\"50\" name=\"fives\"><br>\n" +
            "Twenty-Fives: <br>\n"+
            "<input type=\"text\" id=\"twentyfives\" size=\"50\" name=\"twentyfives\"><br>\n" +
            "Hundreds: <br>\n"+
            "<input type=\"text\" id=\"hundreds\" size=\"50\" name=\"hundreds\"><br>\n" +
            "Two-Hundred-Fifties: <br>\n"+
            "<input type=\"text\" id=\"twohundredfifties\" size=\"50\" name=\"twohundredfifties\"><br>\n" +
            "</div>\n" +
            "</div>\n" +
            "<button class=\"btn btn-large btn-success\">GET</button>\n" +
            "</form>\n" +
            "      <hr>\n" +
            "\n" +
            "\t  \n" +
            "\t\t<div style=\"background-color:PaleGreen; padding:30px; margin:20px;\">\n" +
            "          <h4>private mark_coins_for_sale</h4>\n" +
            "          <p>Get's the bank's welcome information </p>\n" +
            "\t\t  \n" +
            "\t\t  <b>Sample request (test server)</b>\n" +
            "\t\t  <pre id=\"url2\">\t\t  \n" +
            "\thttps://bank.cloudcoin.global//print_welcome\n" +
            "\t\t  \n" +
            "\t\t  </pre>\n" +
            "\t\t  <b>Sample response</b>\n" +
            "\t\t  <pre>{\n" +
            "\t\"bank_server\": \"bank.cloudcoin.global\",\n" +
            "\t\"status\": \"welcome\",\n" +
            "\t\"version\":\"4.07.17\",\n" +
            "\t\"message\": \"CloudCoin Bank. Used to Authenticate, Store and Payout CloudCoins. \n" +
            "\tThis Software is provided as is with all faults, defects and errors, and \n" +
            "\twithout warranty of any kind. Free from the CloudCoin Consortium.\",\n" +
            "\t\"time\": \"2016-40-21 10:40:PM\"\n" +
            "}\n" +
            "\t\t\t\t\n" +
            "\t\t  </pre>\n" +
            "\t\t  \n" +
            "</div>\n" +
            "\n" +
            "     \n" +
            "      <hr>\n" +
            "\n" +
            "      <div class=\"footer\">\n" +
            "        <p>&copy; Company 2018</p>\n" +
            "      </div>\n" +
            "\n" +
            "    </div> \n" +
            "<script>\n" +
            "\t\n" +
            "\t\tvar CurrentUrl=window.location.hostname ;\n" +
            "\t\tdocument.getElementById(\"url\").innerHTML=CurrentUrl+\"//print_welcome\";\n" +
            "\tdocument.getElementById(\"url2\").innerHTML=\"<BR>\"+CurrentUrl+\"//print_welcome<BR><BR>\";\n" +
            "\t\t</script>\n" +
            "    \n" +
            "    \n" +
            "\n" +
            "\n" +
            "  </body>\n" +
            "</html>\n";

    public static final String htmlPrintWelcome = "\n" +
            "\n" +
            "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "<meta charset=\"utf-8\">\n" +
            "<title>Test Print Welcome</title>\n" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "<meta name=\"description\" content=\"\">\n" +
            "<meta name=\"author\" content=\"\">\n" +
            "\n" +
            "<link href=\"../css/bootstrap2.css\" rel=\"stylesheet\">\n" +
            "<style type=\"text/css\">\n" +
            "      body {\n" +
            "        padding-top: 20px;\n" +
            "        padding-bottom: 40px;\n" +
            "      }\n" +
            "\n" +
            "      /* Custom container */\n" +
            "      .container-narrow {\n" +
            "        margin: 0 auto;\n" +
            "        max-width: 700px;\n" +
            "      }\n" +
            "      .container-narrow > hr {\n" +
            "        margin: 30px 0;\n" +
            "      }\n" +
            "\n" +
            "      /* Main marketing message and sign up button */\n" +
            "      .jumbotron {\n" +
            "        margin: 60px 0;\n" +
            "        text-align: center;\n" +
            "      }\n" +
            "      .jumbotron h1 {\n" +
            "        font-size: 72px;\n" +
            "        line-height: 1;\n" +
            "      }\n" +
            "      .jumbotron .btn {\n" +
            "        font-size: 21px;\n" +
            "        padding: 14px 24px;\n" +
            "      }\n" +
            "\n" +
            "      /* Supporting marketing content */\n" +
            "      .marketing {\n" +
            "        margin: 60px 0;\n" +
            "      }\n" +
            "      .marketing p + h4 {\n" +
            "        margin-top: 28px;\n" +
            "      }\n" +
            "    </style>\n" +
            "<link href=\"../css/bootstrap-responsive.css\" rel=\"stylesheet\">\n" +
            "\n" +
            "<!--[if lt IE 9]>\n" +
            "      <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\n" +
            "    <![endif]-->\n" +
            "\n" +
            "</head>\n" +
            "<body>\n" +
            "<div class=\"container-narrow\">\n" +
            "<div class=\"masthead\">\n" +
            "<ul class=\"nav nav-pills pull-right\">\n" +
            "<li class=\"active\"><a href=\"/sandbox\">Home</a></li>\n" +
            "</ul>\n" +
            "<h1 class=\"muted\">Print Welcome</h1>\n" +
            "<h3 class=\"muted\">Test Page</h3>\n" +
            "</div>\n" +
            "<hr>\n" +
            "<div class=\"jumbotron\">\n" +
            "<pre <p>\t\tPress the button get the following URL:\n" +
            "\t\t<span id=\"url\">https://bank.cloudcoin.global//print_welcome/ </span>\n" +
            "\t\t</p>\n" +
            "        <a class=\"btn btn-large btn-success\" href=\"/print_welcome/\">GET /print_welcome</a>\n" +
            "      </div>\n" +
            "\n" +
            "      <hr>\n" +
            "\n" +
            "\t  \n" +
            "\t\t<div style=\"background-color:PaleGreen; padding:30px; margin:20px;\">\n" +
            "          <h4>private print_welcome</h4>\n" +
            "          <p>Get's the bank's welcome information </p>\n" +
            "\t\t  \n" +
            "\t\t  <b>Sample request (test server)</b>\n" +
            "\t\t  <pre id=\"url2\">\t\t  \n" +
            "\thttps://bank.cloudcoin.global//print_welcome\n" +
            "\t\t  \n" +
            "\t\t  </pre>\n" +
            "\t\t  <b>Sample response</b>\n" +
            "\t\t  <pre>{\n" +
            "\t\"bank_server\": \"bank.cloudcoin.global\",\n" +
            "\t\"status\": \"welcome\",\n" +
            "\t\"version\":\"4.07.17\",\n" +
            "\t\"message\": \"CloudCoin Bank. Used to Authenticate, Store and Payout CloudCoins. \n" +
            "\tThis Software is provided as is with all faults, defects and errors, and \n" +
            "\twithout warranty of any kind. Free from the CloudCoin Consortium.\",\n" +
            "\t\"time\": \"2016-40-21 10:40:PM\"\n" +
            "}\n" +
            "\t\t\t\t\n" +
            "\t\t  </pre>\n" +
            "\t\t  \n" +
            "</div>\n" +
            "\n" +
            "     \n" +
            "      <hr>\n" +
            "\n" +
            "      <div class=\"footer\">\n" +
            "        <p>&copy; Company 2018</p>\n" +
            "      </div>\n" +
            "\n" +
            "    </div> \n" +
            "<script>\n" +
            "\t\n" +
            "\t\tvar CurrentUrl=window.location.hostname ;\n" +
            "\t\tdocument.getElementById(\"url\").innerHTML=CurrentUrl+\"//print_welcome\";\n" +
            "\tdocument.getElementById(\"url2\").innerHTML=\"<BR>\"+CurrentUrl+\"//print_welcome<BR><BR>\";\n" +
            "\t\t</script>\n" +
            "    \n" +
            "    \n" +
            "\n" +
            "\n" +
            "  </body>\n" +
            "</html>\n";
    
    public static final String htmlShowCoins = "\n" +
            "\n" +
            "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "<meta charset=\"utf-8\">\n" +
            "<title>Show Coins CloudService</title>\n" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "<meta name=\"description\" content=\"\">\n" +
            "<meta name=\"author\" content=\"\">\n" +
            "\n" +
            "<link href=\"../css/bootstrap2.css\" rel=\"stylesheet\">\n" +
            "<style type=\"text/css\">\n" +
            "      body {\n" +
            "        padding-top: 20px;\n" +
            "        padding-bottom: 40px;\n" +
            "      }\n" +
            "\n" +
            "      /* Custom container */\n" +
            "      .container-narrow {\n" +
            "        margin: 0 auto;\n" +
            "        max-width: 700px;\n" +
            "      }\n" +
            "      .container-narrow > hr {\n" +
            "        margin: 30px 0;\n" +
            "      }\n" +
            "\n" +
            "      /* Main marketing message and sign up button */\n" +
            "      .jumbotron {\n" +
            "        margin: 60px 0;\n" +
            "        text-align: center;\n" +
            "      }\n" +
            "      .jumbotron h1 {\n" +
            "        font-size: 72px;\n" +
            "        line-height: 1;\n" +
            "      }\n" +
            "      .jumbotron .btn {\n" +
            "        font-size: 21px;\n" +
            "        padding: 14px 24px;\n" +
            "      }\n" +
            "\n" +
            "      /* Supporting marketing content */\n" +
            "      .marketing {\n" +
            "        margin: 60px 0;\n" +
            "      }\n" +
            "      .marketing p + h4 {\n" +
            "        margin-top: 28px;\n" +
            "      }\n" +
            "    </style>\n" +
            "<link href=\"../css/bootstrap-responsive.css\" rel=\"stylesheet\">\n" +
            "\n" +
            "<!--[if lt IE 9]>\n" +
            "      <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\n" +
            "    <![endif]-->\n" +
            "\n" +
            "</head>\n" +
            "<body>\n" +
            "<div class=\"container-narrow\">\n" +
            "<div class=\"masthead\">\n" +
            "<ul class=\"nav nav-pills pull-right\">\n" +
            "<li class=\"active\"><a href=\"../sandbox\">Home</a></li>\n" +
            "</ul>\n" +
            "<h1 class=\"muted\">Show Coins</h1>\n" +
            "<h3 class=\"muted\">Show Coins Test</h3>\n" +
            "</div>\n" +
            "<hr>\n" +
            "<div>\n" +
            "<p>Pres the button below to execute the GET request. You must know your own PK and Account.</p>\n" +
            "<p id=\"url\"></p>\n" +
            "<div>\n" +
            "<form name=\"input\" action=\"/show_coins\" method=\"GET\">\n" +
            "<br>\n" +
            "Account:\n" +
            "<br>\n" +
            "<input type=\"Text\" id=\"account\" size=\"50\" name=\"account\" value=\"\">\n" +
            "<br>\n" +
            "Private Key:\n" +
            "<br>\n" +
            "<input type=\"Text\" id=\"pk\" size=\"50\" name=\"pk\" value=\"\">\n" +
            "<br>\n" +
            "<br>\n" +
            "<input type=\"submit\" class=\"btn btn-large btn-success\" value=\"Submit /show_coins\">\n" +
            "<div>\n" +
            "</form>\n" +
            "</div>\n" +
            "<hr>\n" +
            "<div style=\"background-color:WhiteSmoke; padding:30px; margin:20px;\">\n" +
            "<h4>Show Coins</h4>\n" +
            "<p>Gets the totals of CloudCoins in the bank. </p>\n" +
            "<b>Sample request</b>\n" +
            "<pre id=\"url2\">\t\t  \n" +
            "\thttps://bank.cloudcoin.global//show_coins\n" +
            "\t\t  \n" +
            "\t\t  </pre>\n" +
            "<b>Sample response if good:</b>\n" +
            "<pre>{\n" +
            "\t\"bank_server\":\"Bank.CloudCoin.Global\",\n" +
            "\t\"account\":\"<a href=\"/cdn-cgi/l/email-protection\" class=\"__cf_email__\" data-cfemail=\"7c3f101309183f1315123c2c0e13081312111d1510521f1311\">[email&#160;protected]</a>\",\n" +
            "\t\"status\":\"coins_shown\",\n" +
            "\t\"message\":\"Coin totals returned.\",\n" +
            "\t\"ones\":3,\n" +
            "\t\"fives\":0,\n" +
            "\t\"twentyfives\":0,\n" +
            "\t\"hundreds\":0,\n" +
            "\t\"twohundredfifties\":1,\n" +
            "\t\"time\":\"2018-06-23T05:53:39.4155794Z\",\n" +
            "\t\"version\":\"2.0\"\n" +
            "}\n" +
            "\t\t\t\t\n" +
            "\t\t  </pre>\n" +
            "<b>Sample Response if fail:</b>\n" +
            "<pre>{\n" +
            "\t \"bank_server\":\"bank.cloudcoin.global\",\n" +
            "\t \"account\":\"<a href=\"/cdn-cgi/l/email-protection\" class=\"__cf_email__\" data-cfemail=\"27644b48524364484e49677755485348494a464e4b0944484a\">[email&#160;protected]</a>\",\n" +
            "\t \"status\":\"fail\",\n" +
            "\t \"message\":\"Private key incorrect\"\n" +
            "\t \"ones\":0,\n" +
            "\t \"fives\":0,\n" +
            "\t \"twentyfives\":0,\n" +
            "\t \"hundreds\":0,\n" +
            "\t \"twohundredfifties\":0,\n" +
            "\t \"time\":\"2018-06-23T05:53:39.4155794Z\",\n" +
            "\t \"version\":\"2.0\"\n" +
            "}\n" +
            "\t\t\t\t\n" +
            "\t\t  </pre>\n" +
            "</div>\n" +
            "<hr>\n" +
            "</div> \n" +
            "<script data-cfasync=\"false\" src=\"/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js\"></script><script>\n" +
            "\t\n" +
            "\t\tvar CurrentUrl=window.location.host ;\n" +
            "\t\tdocument.getElementById(\"url\").innerHTML=CurrentUrl + \"//echo?account=CloudCoin@Protonmail.com&pk=640322f6d30c45328914b441ac0f4e5b\";\n" +
            "\tdocument.getElementById(\"url2\").innerHTML=\"<BR>\"+CurrentUrl+\"//echo?account=CloudCoin@Protonmail.com&pk=640322f6d30c45328914b441ac0f4e5b<BR><BR>\";\n" +
            "\t\t</script>\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>\n";

    public static final String htmlWithdraw = "\n" +
            "\n" +
            "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "<meta charset=\"utf-8\">\n" +
            "<title>Withdraw One Stack</title>\n" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "<meta name=\"description\" content=\"\">\n" +
            "<meta name=\"author\" content=\"\">\n" +
            "\n" +
            "<link href=\"../css/bootstrap2.css\" rel=\"stylesheet\">\n" +
            "<style type=\"text/css\">\n" +
            "      body {\n" +
            "        padding-top: 20px;\n" +
            "        padding-bottom: 40px;\n" +
            "      }\n" +
            "\n" +
            "      /* Custom container */\n" +
            "      .container-narrow {\n" +
            "        margin: 0 auto;\n" +
            "        max-width: 700px;\n" +
            "      }\n" +
            "      .container-narrow > hr {\n" +
            "        margin: 30px 0;\n" +
            "      }\n" +
            "\n" +
            "      /* Main marketing message and sign up button */\n" +
            "      .jumbotron {\n" +
            "        margin: 60px 0;\n" +
            "        text-align: center;\n" +
            "      }\n" +
            "      .jumbotron h1 {\n" +
            "        font-size: 72px;\n" +
            "        line-height: 1;\n" +
            "      }\n" +
            "      .jumbotron .btn {\n" +
            "        font-size: 21px;\n" +
            "        padding: 14px 24px;\n" +
            "      }\n" +
            "\n" +
            "      /* Supporting marketing content */\n" +
            "      .marketing {\n" +
            "        margin: 60px 0;\n" +
            "      }\n" +
            "      .marketing p + h4 {\n" +
            "        margin-top: 28px;\n" +
            "      }\n" +
            "    </style>\n" +
            "<link href=\"../css/bootstrap-responsive.css\" rel=\"stylesheet\">\n" +
            "\n" +
            "<!--[if lt IE 9]>\n" +
            "      <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\n" +
            "    <![endif]-->\n" +
            "\n" +
            "</head>\n" +
            "<body>\n" +
            "<div class=\"container-narrow\">\n" +
            "<div class=\"masthead\">\n" +
            "<ul class=\"nav nav-pills pull-right\">\n" +
            "<li class=\"active\"><a href=\"/sandbox\">Home</a></li>\n" +
            "</ul>\n" +
            "<h1 class=\"muted\">Withdraw One Stack</h1>\n" +
            "<h3 class=\"muted\">Test Withdraw One Stack Service</h3>\n" +
            "</div>\n" +
            "<hr>\n" +
            "<div>\n" +
            "GET Stack from CloudBank using:\n" +
            "<pre>\thttps://<span id=\"url\"></span>//withdraw_one_stack?a<a href=\"/cdn-cgi/l/email-protection\" class=\"__cf_email__\" data-cfemail=\"2845475d465c151a1d1c0e5843154d4e1d181810104b101a1910494e4d1d1b4b4d1a4d4b4c1e1d1d4b1a4b1f101e0e494b4b475d465c156b44475d4c6b47414668\">[email&#160;protected]</a>Protonmail.com\n" +
            "</pre>\n" +
            "<form name=\"input\" action=\"/withdraw_one_stack/\" method=\"GET\">\n" +
            "<br>\n" +
            "Amount:\n" +
            "<br>\n" +
            "<input type=\"Number\" min=\"0\" id=\"amount\" name=\"amount\" value=\"\">\n" +
            "<br>\n" +
            "Account:\n" +
            "<br>\n" +
            "<input type=\"Text\" size=\"50\" id=\"account\" name=\"account\" value=\"\">\n" +
            "<br>\n" +
            "Private Key:\n" +
            "<br>\n" +
            "<input type=\"Text\" id=\"pk\" size=\"50\" name=\"pk\" value=\"\">\n" +
            "<br>\n" +
            "<br>\n" +
            "<input type=\"submit\" class=\"btn btn-large btn-success\" value=\"Get Stack\">\n" +
            "</form>\n" +
            "</div>\n" +
            "<hr>\n" +
            "<div style=\"background-color:LightSalmon; padding:30px; margin:20px;\">\n" +
            "<h4>private withdraw_account</h4>\n" +
            "<p>Asks the CloudBank to send it a stack file and remove those coins from the bank.</p>\n" +
            "<b>Sample GET Request:</b>\n" +
            "<pre>\t\t  \n" +
            "\t<span id=\"url2\">https://bank.cloudcoin.global</span>//withdraw_account?a<a href=\"/cdn-cgi/l/email-protection\" class=\"__cf_email__\" data-cfemail=\"5934362c372d646b6c6d7f2932643c3f6c696961613a616b6861383f3c6c6a3a3c6b3c3a3d6f6c6c3a6b3a6e616f7f383a3a362c372d641a35362c3d1a36303719\">[email&#160;protected]</a>Protonmail.com\n" +
            "\n" +
            "\t\t  \n" +
            "\t\t  </pre>\n" +
            "<b>Sample response if good</b>\n" +
            "<pre>{\n" +
            "\t\"cloudcoin\": [\n" +
            "\t\t{ \n" +
            "\t\t\"nn\":\"1\", \n" +
            "\t\t\"sn\":\"1112240\", \n" +
            "\t\t\"an\": [\n" +
            "\t\t\"f5a52ee881daaae548c24a8eaff7176c\", \"415c2375a6fa48c4661f5af8d7c95541\", \n" +
            "\t\t\"73e067b7b47c1556deebdca33f9a09fb\", \"9b90d265d102a565a702813fa2211f54\", \n" +
            "\t\t\"e3e191ca987c8010a3adc49c6fc18417\", \"baa7578e207b7cfaa0b8336d7ed4a4f8\", \n" +
            "\t\t\"6d8a5c66a589532fe9e5dc3932650cfa\", \"1170b354e097f2d90132869631409bd3\", \n" +
            "\t\t\"b7bc83e8ee7529ff9f874866b901cf15\", \"a37f6c4af8fbcfbc4d77880fc29ddfbc\",\n" +
            "\t\t\"277668208e9bafd9393aebd36945a2c3\", \"ef50088c8218afe53ce2ecd655c2c786\", \n" +
            "\t\t\"b7bbb01fbe6c3a830a17bd9a842b46c0\", \"737360e18596d74d784f563ca729aaea\", \n" +
            "\t\t\"e054a34f2790fd3353ea26e5d92d9d2f\",\t\"7051afef36dc388e65e982bc853be417\", \n" +
            "\t\t\"ea22cbae0394f6c6918691f2e2f2e267\", \"95d1278f54b5daca5898c62f267b6364\", \n" +
            "\t\t\"b98560e11b7142d1addf5b9cf32898da\", \"e325f615f93ed682c7aadf6b2d77c17a\",\n" +
            "\t\t\"3e8f9d74290fe31d416b90db3a0d2ab1\", \"c92d1656ded0a4f68e5171c8331e0aea\", \n" +
            "\t\t\"7a9cee66544934965bca0c0cb582ba73\", \"7a55437fa98c1b10d7f47d84f9accdf0\", \n" +
            "\t\t\"c3577cced2d428f205355522bc1119b6\"],\n" +
            "\t\t\"ed\":\"7-2019\",\n" +
            "\t\t\"pown\":\"ppppppppppppppppppppppppp\",\n" +
            "\t\t\"aoid\": []\n" +
            "\t\t},\n" +
            "\t\t{ \n" +
            "\t\t\"nn\":\"1\", \n" +
            "\t\t\"sn\":\"1112241\", \n" +
            "\t\t\"an\": [\n" +
            "\t\t\"f5a52ee881daaae548c24a8eaff7176c\", \"415c2375a6fa48c4661f5af8d7c95541\", \n" +
            "\t\t\"73e067b7b47c1556deebdca33f9a09fb\", \"9b90d265d102a565a702813fa2211f54\", \n" +
            "\t\t\"e3e191ca987c8010a3adc49c6fc18417\", \"baa7578e207b7cfaa0b8336d7ed4a4f8\", \n" +
            "\t\t\"6d8a5c66a589532fe9e5dc3932650cfa\", \"1170b354e097f2d90132869631409bd3\", \n" +
            "\t\t\"b7bc83e8ee7529ff9f874866b901cf15\", \"a37f6c4af8fbcfbc4d77880fc29ddfbc\",\n" +
            "\t\t\"277668208e9bafd9393aebd36945a2c3\", \"ef50088c8218afe53ce2ecd655c2c786\", \n" +
            "\t\t\"b7bbb01fbe6c3a830a17bd9a842b46c0\", \"737360e18596d74d784f563ca729aaea\", \n" +
            "\t\t\"e054a34f2790fd3353ea26e5d92d9d2f\",\t\"7051afef36dc388e65e982bc853be417\", \n" +
            "\t\t\"ea22cbae0394f6c6918691f2e2f2e267\", \"95d1278f54b5daca5898c62f267b6364\", \n" +
            "\t\t\"b98560e11b7142d1addf5b9cf32898da\", \"e325f615f93ed682c7aadf6b2d77c17a\",\n" +
            "\t\t\"3e8f9d74290fe31d416b90db3a0d2ab1\", \"c92d1656ded0a4f68e5171c8331e0aea\", \n" +
            "\t\t\"7a9cee66544934965bca0c0cb582ba73\", \"7a55437fa98c1b10d7f47d84f9accdf0\", \n" +
            "\t\t\"c3577cced2d428f205355522bc1119b6\"],\n" +
            "\t\t\"ed\":\"7-2019\",\n" +
            "\t\t\"pown\":\"ppppppppppppppppppppppppp\",\n" +
            "\t\t\"aoid\": []\n" +
            "\t\t}\n" +
            "\t]\n" +
            "}\n" +
            "\t\t\t\t\n" +
            "\t\t  </pre>\n" +
            "</div>\n" +
            "</div> \n" +
            "<script data-cfasync=\"false\" src=\"/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js\"></script><script>\n" +
            "\t\n" +
            "\t\tvar CurrentUrl=window.location.host ;\n" +
            "\t\t\t\n" +
            "\t\tdocument.getElementById(\"url\").innerHTML=CurrentUrl;\n" +
            "\t\tdocument.getElementById(\"url2\").innerHTML=CurrentUrl;\n" +
            "\t\tdocument.getElementById(\"url3\").innerHTML=CurrentUrl;\n" +
            "\t\tdocument.getElementById(\"url4\").innerHTML=CurrentUrl;\n" +
            "\t\tdocument.getElementById(\"url5\").innerHTML=CurrentUrl;\n" +
            "\t</script>\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>\n";

    public static final String htmlWriteCheck = "\n" +
            "\n" +
            "\n" +
            "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "<meta charset=\"utf-8\">\n" +
            "<title>Template &middot; Bootstrap 2.2.2 Documentation - BootstrapDocs</title>\n" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "<meta name=\"description\" content=\"\">\n" +
            "<meta name=\"author\" content=\"\">\n" +
            "\n" +
            "<link href=\"../css/bootstrap2.css\" rel=\"stylesheet\">\n" +
            "<style type=\"text/css\">\n" +
            "      body {\n" +
            "        padding-top: 20px;\n" +
            "        padding-bottom: 40px;\n" +
            "      }\n" +
            "\n" +
            "      /* Custom container */\n" +
            "      .container-narrow {\n" +
            "        margin: 0 auto;\n" +
            "        max-width: 700px;\n" +
            "      }\n" +
            "      .container-narrow > hr {\n" +
            "        margin: 30px 0;\n" +
            "      }\n" +
            "\n" +
            "      /* Main marketing message and sign up button */\n" +
            "      .jumbotron {\n" +
            "        margin: 60px 0;\n" +
            "        text-align: center;\n" +
            "      }\n" +
            "      .jumbotron h1 {\n" +
            "        font-size: 72px;\n" +
            "        line-height: 1;\n" +
            "      }\n" +
            "      .jumbotron .btn {\n" +
            "        font-size: 21px;\n" +
            "        padding: 14px 24px;\n" +
            "      }\n" +
            "\n" +
            "      /* Supporting marketing content */\n" +
            "      .marketing {\n" +
            "        margin: 60px 0;\n" +
            "      }\n" +
            "      .marketing p + h4 {\n" +
            "        margin-top: 28px;\n" +
            "      }\n" +
            "    </style>\n" +
            "<link href=\"../css/bootstrap-responsive.css\" rel=\"stylesheet\">\n" +
            "\n" +
            "<!--[if lt IE 9]>\n" +
            "      <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\n" +
            "    <![endif]-->\n" +
            "\n" +
            "</head>\n" +
            "<body>\n" +
            "<div class=\"container-narrow\">\n" +
            "<div class=\"masthead\">\n" +
            "<ul class=\"nav nav-pills pull-right\">\n" +
            "<li class=\"active\"><a href=\"/sandbox\">Home</a></li>\n" +
            "</ul>\n" +
            "<h3 class=\"muted\">Write Check Test</h3>\n" +
            "</div>\n" +
            "<hr>\n" +
            "<div>\n" +
            "<p>Pres the button below to execute the following Get request</p>\n" +
            "<p>https://bank.cloudcoin.global//write_check/</p>\n" +
            "<div>\n" +
            "<form name=\"input\" action=\"/write_check/\" method=\"get\">\n" +
            "<br>\n" +
            "Account: <br>\n" +
            "<input name=\"account\"><br>\n" +
            "Private Key:\n" +
            "<br>\n" +
            "<input type=\"Text\" id=\"pk\" size=\"50\" name=\"pk\" value=\"\">\n" +
            "<br>\n" +
            "Action (How the check will be sent):\n" +
            "<br>\n" +
            "<select name=\"action\">\n" +
            "<option value=\"url\" selected>url</option>\n" +
            "</select>\n" +
            "<br>\n" +
            "Amount:\n" +
            "<br>\n" +
            "<input type=\"Text\" id=\"amount\" name=\"amount\" value=\"\">\n" +
            "<br>\n" +
            "Email To:\n" +
            "<br>\n" +
            "<input type=\"email\" id=\"emailto\" size=\"50\" name=\"emailto\" value=\"\">\n" +
            "<br>\n" +
            "Pay To:\n" +
            "<br>\n" +
            "<input type=\"Text\" id=\"payto\" size=\"50\" name=\"payto\" value=\"\">\n" +
            "<br>\n" +
            "Email From:\n" +
            "<br>\n" +
            "<input type=\"email\" id=\"fromemail\" size=\"50\" name=\"fromemail\" value=\"\">\n" +
            "<br>\n" +
            "Signed By:\n" +
            "<br>\n" +
            "<input type=\"Text\" id=\"signby\" size=\"50\" name=\"signby\" value=\"\">\n" +
            "<br>\n" +
            "Memo:\n" +
            "<br>\n" +
            "<input type=\"Text\" id=\"memo\" size=\"50\" name=\"memo\" value=\"\">\n" +
            "<br>\n" +
            "<br>\n" +
            "<input type=\"submit\" class=\"btn btn-large btn-success\" value=\"Submit\">\n" +
            "</form>\n" +
            "</div>\n" +
            "</div>\n" +
            "<hr>\n" +
            "<div style=\"background-color:WhiteSmoke; padding:30px; margin:20px;\">\n" +
            "<h4>Write Check</h4>\n" +
            "<p>Creates a check</p>\n" +
            "<b>Sample request</b>\n" +
            "<pre>\t\t  \n" +
            "\t<span id=url>https://ccc.CloudCoin.Global</span>//write_check\n" +
            "\tpk=a4b5e66f4b51418e81e8dc93e9db6503\n" +
            "\tamount=25\n" +
            "\tpayto=Billy Jenkins\n" +
            "\tsignby=Sean Worthington\n" +
            "\tMemo=For Yard Work\n" +
            "\t\t  \n" +
            "\t\t  </pre>\n" +
            "<b>Sample response if good:</b>\n" +
            "<pre>{\n" +
            " \"bank_server\":\"bank.cloudcoin.global\",\n" +
            " \"status\":\"url\",\n" +
            " \"message\":\"https://bank.CloudCoin.Global/checks?id=c3c3ab7b75ab4d089d2d4a287c1ef232\",\n" +
            " \"time\":\"2016-49-21 7:49:PM\"\n" +
            "}\n" +
            "\t\t\t\t\n" +
            "\t\t  </pre>\n" +
            "<b>Sample Response if fail:</b>\n" +
            "<pre>{\n" +
            " \"bank_server\":\"bank.cloudcoin.global\",\n" +
            " \"status\":\"error\",\n" +
            " \"message\":\"Not enough funds to write Check for 250 CloudCoins to <a href=\"/cdn-cgi/l/email-protection\" class=\"__cf_email__\" data-cfemail=\"56143f3a3a162f3724322139243d7835393b\">[email&#160;protected]</a>\",\n" +
            " \"time\":\"2016-49-21 7:49:PM\"\n" +
            "}\n" +
            "\t\t\t\t\n" +
            "\t\t  </pre>\n" +
            "</div>\n" +
            "<hr>\n" +
            "</div> \n" +
            "<script data-cfasync=\"false\" src=\"/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js\"></script><script>\n" +
            "var CurrentUrl=window.location.pathname ;\n" +
            "\t\tdocument.getElementById(\"url\").innerHTML=CurrentUrl;\n" +
            "</script>\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>\n" +
            "\n";
}
