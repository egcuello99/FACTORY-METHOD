package com.example.demo.PDFReport;

public class PDFReportDirector {
    public PDFReport buildSimpleReport(String title) {
        return new PDFReport.Builder()
                .title(title)
                .includeLogo(false)
                .includeUserInfo(false)
                .footerMessage("Transacción completada")
                .build();
    }

    public PDFReport buildDetailedReport(String title, String clientName) {
        return new PDFReport.Builder()
                .title(title)
                .includeLogo(true)
                .includePaymentDetails(true)
                .includeUserInfo(true)
                .theme(Theme.LIGHT)
                .includeTimestamp(true)
                .footerMessage("Gracias " + clientName + " por su preferencia")
                .format(Format.A4)
                .build();
    }

    public PDFReport buildCorporateReport() {
        return new PDFReport.Builder()
                .title("Reporte Corporativo")
                .includeLogo(true)
                .includePaymentDetails(true)
                .includeUserInfo(true)
                .theme(Theme.DARK)
                .includeTimestamp(true)
                .footerMessage("Confidencial - Uso interno")
                .format(Format.LETTER)
                .build();
    }
}
