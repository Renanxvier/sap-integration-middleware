package com.syncedcorp.sapintegration.model;

public enum OrderStatus {
    PENDING,        // Pedido recebido, aguardando envio ao SAP
    SYNCED_WITH_SAP,// Integrado com sucesso no ERP SAP
    FAILED          // Falha na comunicação com o SAP (enfileirado para reenvio)
}