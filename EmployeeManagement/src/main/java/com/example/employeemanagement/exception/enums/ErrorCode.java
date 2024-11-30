package com.example.employeemanagement.exception.enums;

import com.example.employeemanagement.exception.dtos.BaseErrorCode;
import lombok.Getter;

@Getter
public enum ErrorCode implements BaseErrorCode<ErrorCode> {

    // NOT_FOUND
    NOT_FOUND_FILE("not.found.file", "Not Found File"),
    NOT_FOUND_BRANCH("not.found.branch", "Not Found branch"),
    NOT_FOUND_PERSON("not.found.person", "Not Found Person"),
    NOT_FOUND_MESSAGE("not.found.message", "No Message Found"),
    NOT_FOUND_COMPANY("not.found.company", "Not Found Company"),
    NOT_FOUND_ADDRESS("not.found.address", "Not Found Address"),
    NOT_FOUND_PARTNER("not.found.partner", "Not Found Partner"),
    NOT_FOUND_SUPPLIER("not.found.supplier","Not Found Supplier"),
    NOT_FOUND_EMPLOYEE("not.found.employee", "Not Found employee"),
    NOT_FOUND_DOCUMENT("not.found.document", "Not Found Document"),
    NOT_FOUND_RESOURCE("not.found.resource", "Not found resource"),
    NOT_FOUND_APPLICANT("not.found.applicant", "Not found applicant"),
    NOT_FOUND_CIVIL_DATA("not.found.civil.data", "Not Found Civil Data"),
    NOT_FOUND_APPLICATION("not.found.application", "Not found application"),
    NOT_FOUND_DISBURSEMENT("not.found.disbursement", "Not found disbursement"),
    NOT_FOUND_APPLICATION_ID("not.found.application.id", "Not found application id"),
    NOT_FOUND_DOCUMENT_DETAILS("not.found.document.details", "Not Found Document Details"),
    NOT_FOUND_SECTION_INDICATOR("not.found.section.indicator", "Not found section indicator"),
    NOT_FOUND_VISIT_INFORMATION("not.found.visit.information", "Not found visit information"),
    NOT_FOUND_FINANCIAL_DATA_FILE("not.found.financial.data.file", "Not Found Financial Data File"),
    NOT_FOUND_BANK_STATEMENT_FILE("not.found.bank.statement.file", "Not Found Bank Statement File"),
    NOT_FOUND_FACILITY_INFORMATION("not.found.facility.information", "Not found facility information"),
    NOT_FOUND_INVESTIGATION_RESULT_INFORMATION("not.found.investigation.result.information", "Not found investigation result information"),
    NOT_FOUND_CPM_INFORMATION("not.found.cpm.information", "Not found Digital Memo CPM information"),
    NOT_FOUND_BUSINESS_INFORMATION("not.found.business.information", "Not Found Business Information "),
    NOT_FOUND_DOCUMENT_IDENTITY_GROUP("not.found.document.identity.group", "Not Found Document Identity Group"),
    NOT_FOUND_GUARANTOR("not.found.guarantor","Not found Guarantor"),
    NOT_FOUND_MORTGAGE("not.found.mortgage","Not Found Guarantor"),

    // NOT_ALLOWED
    NOT_ALLOWED_ACCEPTANCE("not.allowed.acceptance", "Not Allowed Acceptance"),
    NOT_ALLOWED_TASK_ASSIGNEE("not.allowed.task.assignee", "Not Allowed Task Assignee"),
    NOT_ALLOWED_RESULT_STATUS("not.allowed.result.status", "Not Allowed Result Status"),
    NOT_ALLOWED_DOCUMENT_STATUS("not.allowed.document.status", "Not Allowed Document Status"),
    NOT_ALLOWED_UPLOAD_NEW_FILE("not.allowed.to.upload.new.files", "Not Allowed to upload new file"),
    NOT_ALLOWED_APPLICATION_STATUS("not.allowed.application.status", "Not Allowed Application Status"),
    NOT_ALLOWED_CREATE_NEW_DOCUMENT("not.allowed.to.create.new.document", "Not Allowed to Creating new Document"),
    NOT_ALLOWED_DOCUMENT_STEP_INDICATOR("not.allowed.document.step.indicator", "Not Allowed Document Step Indicator"),
    NOT_ALLOWED_SECTION_INDICATOR_ACTIVATION("not.allowed.section.indicator.activation", "Not allowed section indicator activation"),
    NOT_ALLOWED_ANSWER_ON_DIFFERENT_QUESTION_TYPE("not.allowed.answer.on.different.question.type", "Not allowed answer on different question type"),
    NOT_ALLOWED_COMPLETE_WITHOUT_ANSWERING_ALL_DOCUMENTS("not.allowed.complete.without.answering.all.documents", "Not allowed complete without answering all documents"),
    NOT_ALLOWED_SUBMITTING_WITHOUT_UPLOAD_REJECTED_DOCUMENTS("not.allowed.submitting.without.upload.rejected.documents", "Not Allowed Submitting without Upload Rejected Documents"),
    NOT_ALLOWED_SUBMITTING_WITHOUT_UPDATING_ALL_SUPPLIERS("not.allowed.submitting.without.uploading.all.suppliers", "Not Allowed Submitting without Updating All Suppliers"),
    // NOT_VALID
    NOT_VALID_CARD("not.valid.card", "Not Valid Card"),
    NOT_VALID_INPUT("not.valid.input", "Not Valid Input"),
    NOT_VALID_CREDENTIALS("not.valid.credential", "Invalid username or password"),
    NOT_VALID_DOCUMENTS_LIST("not.valid.documents.list", "Not Valid Documents List"),
    NOT_VALID_NATIONAL_ID("not.valid.nid","national is not valid"),
    NOT_VALID_REQUEST_FILE_SIZE("not.valid.request.file.size", "Not Valid request file size"),
    NOT_VALID_INPUT_TYPE_DROP_DOWN("not.valid.input.type.drop.down", "Not Valid Input Type Drop Down"),
    NOT_VALID_REQUEST_FILE_EXTENSION("not.valid.request.file.extension", "Not Valid request file extension"),
    NOT_VALID_REQUEST_CUSTOMER_DATA("not.valid.request.customer.data", "applicantCbeNo, companyCif, applicantCif must not be empty"),

    // NOT_SUPPORTED
    NOT_SUPPORTED_EXTENSION_TYPE("not.supported.extension.type", "Not supported extension type"),
    NOT_SUPPORTED_QUEUING_SYSTEM("not.supported.queuing.system", "Not supported queuing system"),

    // NOT_MATCH
    NOT_MATCH_ALL_ANSWERS_SAME_DOCUMENT("not.match.all.answers.same.document", "Not Match all answers same document"),
    NOT_MATCH_ALL_ANSWERS_QUESTION_TYPE("not.match.all.answers.question.type", "Not Match all answers question type"),
    NOT_MATCH_REQUEST_FILE_SIZE_WITH_REAL_UPLOADED_FILE("not.match.request.file.size.with.real.uploaded.file", "Not Match Request file size with real uploaded file"),

    // EXCEED_LIMIT
    EXCEED_LIMIT_FILE_SIZE("exceed.limit.file.size", "Exceed Limit File Size"),
    DISBURSEMENT_AMOUNT_EXCEEDS_AVAILABLE_LIMIT("disbursement.amount.exceeds.available.limit", "Disbursement amount exceeds available limit"),
    // EXCEPTION
    EXCEPTION_FCUBS("exception.fcubs", "Exception Fcubs"),
    EXCEPTION_SMS("exception.sent.sms", "Exception sent SMS"),
    EXCEPTION_DATE_PARSE("exception.date.parse", "Exception Date parse"),
    EXCEPTION_PIN_VALIDATION("exception.pin.validation", "Exception pin validation"),
    EXCEPTION_QUEUING_BRANCHES("exception.queuing.branches", "Exception Queuing Branches"),
    EXCEPTION_APPOINTMENT_DAYS("exception.appointment.days", "Exception appointment days"),
    EXCEPTION_AVAILABLE_SERVICE("exception.available.service", "Exception available service"),
    EXCEPTION_APPOINTMENT_SCHEDULE("exception.appointment.schedule", "Exception appointment schedule"),
    EXCEPTION_AVAILABLE_TIME_SLOTS("exception.available.time.slots", "Exception available time slots"),
    EXCEPTION_ELECTRICITY("exception.electricity","Exception Electricity Service"),

    // EXPIRED
    EXPIRED_CARD("expired.card", "Expired Card"),
    EXPIRED_PASSWORD("expired.password", "Password is expired, please contact your administrator"),

    // OTHER
    SECRET_DATA("secret.data", "Secret Data"),
    INACTIVE_CARD("inactive.card", "Inactive Card"),
    UNAUTHORIZED("unauthorized", "Unauthorized User"),
    FORBIDDEN("forbidden", "Forbidden"),
    BLOCKED_USER("blocked.user", "You have been blocked"),
    STOPPED_CITIZEN("stopped.citizen", "Stopped Citizen"),
    CITIZEN_DECEASED("citizen.deceased", "Citizen Deceased"),
    WRONG_NATIONAL_ID("wrong.national.id", "Wrong National Id"),
    NATIONAL_ID_ALREADY_EXISTS("nid.exists","National Id already exists"),
    EXIST_APPLICATION("exist.application", "Application Already Exist"),
    SOMETHING_WENT_WRONG("something.went.wrong", "Something went Wrong!"),
    FEIGN_CLIENT_EXPECTATION("something.went.wrong", "feign client exception happened"),
    EXIST_APPLICATION_DATA("exist.application.data.found", "Application Already Exist"),
    DISABLED_USER("disabled.user", "User is disabled, please contact the administration"),
    NEW_TO_BANK_CUSTOMER("new.to.bank.customer", "New to Bank Customer"),
    PLEASE_ANSWER_ALL_QUESTIONS("please.answer.all.questions", "Please answer all questions"),
    APPLICATION_ALREADY_ASSIGNED("application.already.assigned", "Application already assigned!"),
    NOT_AVAILABLE_APPOINTMENT_TIME("not.available.appointment.time", "Not available appointment time"),
    NOT_WORKING_BRANCH_AT_THIS_TIME("not.working.branch.at.this.time", "Not working branch at this time"),
    MAX_ONE_APPOINTMENT_PER_SERVICE_PER_DAY("max.one.appointment.per.service.per.day", "Max one appointment per service per day"),
    PREVIOUS_SECTION_TAB_INCOMPLETE("previous.section.tab.not.completed", "Previous section tab is not completed"),
    STATUS_NOT_ALLOWED("not.status.allowed","You can not change request status"),

    //fein client
    APPLICATION_RETRIEVAL_FEIGN_CLIENT_ERROR("feign.client.application.retrieval.error", "something went wrong while calling application retrieval service"),
    APPLICATION_UPDATE_FEIGN_CLIENT_ERROR("feign.client.application.update.error", "something went wrong while calling application update service"),
    MISSING_FIELD("field.required","field.required"),
    NOT_RELATED_APPLICATION("not.related.application","not related application"),
    INVALID_INVESTIGATION_ANSWERS("invalid.answer","invalid.answer");

    private final String messageCode;
    private final String description;

    ErrorCode(String messageCode, String description) {
        this.messageCode = messageCode;
        this.description = description;
    }

}
