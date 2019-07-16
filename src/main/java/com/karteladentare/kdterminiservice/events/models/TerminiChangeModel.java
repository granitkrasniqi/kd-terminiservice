package com.karteladentare.kdterminiservice.events.models;

/**
 * @author Granit Krasniqi
 * date: 7/16/2019
 * email: granitkrasniqi@outlook.com
 */
public class TerminiChangeModel {
    private String type;
    private String action;
    private String terminiId;
    private String correlationId;

    public TerminiChangeModel(String type, String action, String terminiId, String correlationId) {
        this.type = type;
        this.action = action;
        this.terminiId = terminiId;
        this.correlationId = correlationId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTerminiId() {
        return terminiId;
    }

    public void setTerminiId(String terminiId) {
        this.terminiId = terminiId;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }
}
