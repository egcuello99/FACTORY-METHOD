package com.example.demo.PDFReport;

public class PDFReport {
    private boolean includeLogo;
    private String title;
    private boolean includePaymentDetails;
    private boolean includeUserInfo;
    private Theme theme;
    private boolean includeTimestamp;
    private String footerMessage;
    private Format format;

    // Constructor privado para usar con el Builder
    private PDFReport(Builder builder) {
        this.includeLogo = builder.includeLogo;
        this.title = builder.title;
        this.includePaymentDetails = builder.includePaymentDetails;
        this.includeUserInfo = builder.includeUserInfo;
        this.theme = builder.theme;
        this.includeTimestamp = builder.includeTimestamp;
        this.footerMessage = builder.footerMessage;
        this.format = builder.format;
    }

    // Método para generar el PDF (simulado)
    public void generate() {
        System.out.println("Generando reporte PDF con las siguientes configuraciones:");
        System.out.println(this.toString());
        // Aquí iría la lógica real de generación del PDF
    }

    @Override
    public String toString() {
        return "PDFReport{" +
                "includeLogo=" + includeLogo +
                ", title='" + title + '\'' +
                ", includePaymentDetails=" + includePaymentDetails +
                ", includeUserInfo=" + includeUserInfo +
                ", theme=" + theme +
                ", includeTimestamp=" + includeTimestamp +
                ", footerMessage='" + footerMessage + '\'' +
                ", format=" + format +
                '}';
    }

    // Builder estático interno
    public static class Builder {
        // Campos con valores por defecto
        private boolean includeLogo = false;
        private String title = "Reporte de Pago";
        private boolean includePaymentDetails = true;
        private boolean includeUserInfo = true;
        private Theme theme = Theme.LIGHT;
        private boolean includeTimestamp = true;
        private String footerMessage = "Gracias por su compra";
        private Format format = Format.A4;

        public Builder includeLogo(boolean includeLogo) {
            this.includeLogo = includeLogo;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder includePaymentDetails(boolean includePaymentDetails) {
            this.includePaymentDetails = includePaymentDetails;
            return this;
        }

        public Builder includeUserInfo(boolean includeUserInfo) {
            this.includeUserInfo = includeUserInfo;
            return this;
        }

        public Builder theme(Theme theme) {
            this.theme = theme;
            return this;
        }

        public Builder includeTimestamp(boolean includeTimestamp) {
            this.includeTimestamp = includeTimestamp;
            return this;
        }

        public Builder footerMessage(String footerMessage) {
            this.footerMessage = footerMessage;
            return this;
        }

        public Builder format(Format format) {
            this.format = format;
            return this;
        }

        public PDFReport build() {
            return new PDFReport(this);
        }
    }
}
