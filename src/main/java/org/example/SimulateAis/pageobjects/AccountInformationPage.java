package org.example.SimulateAis.pageobjects;

import org.example.SimulateAis.config.driverfactory.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountInformationPage {

    public AccountInformationPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='consents-authorisation']")
    private WebElement endpointAuthorisationName;

    @FindBy(xpath = "(//*[@class='url-verb'])[1]")
    private WebElement endpointAuthorisationMethod;

    @FindBy(xpath = "(//*[@class='request-url'])[1]")
    private WebElement endpointAuthorisationUri;

    @FindBy(xpath = "(//h5[text() = 'Headers'])[1]")
    private WebElement headersAuthorisation;

    @FindBy(xpath = "(//*[@class='cell first-title'])[1]")
    private WebElement xRequestIdAuthorisation;

    @FindBy(xpath = "(//*[@class='cell type'])[1]")
    private WebElement xRequestIdTypeAuthorisation;

    @FindBy(xpath = "(//*[@class='cell first-title'])[2]")
    private WebElement digestAuthorisation;

    @FindBy(xpath = "(//*[@class='cell type'])[2]")
    private WebElement digestTypeAuthorisation;

    @FindBy(xpath = "(//*[@class='cell first-title'])[3]")
    private WebElement dateAuthorisation;

    @FindBy(xpath = "(//*[@class='cell type'])[3]")
    private WebElement dateTypeAuthorisation;

    @FindBy(xpath = "(//*[@class='cell first-title'])[4]")
    private WebElement psuIdAuthorisation;

    @FindBy(xpath = "(//*[@class='cell type'])[4]")
    private WebElement psuIdTypeAuthorisation;

    @FindBy(xpath = "(//*[@class='cell first-title'])[5]")
    private WebElement psuCorporateIdAuthorisation;

    @FindBy(xpath = "(//*[@class='cell type'])[5]")
    private WebElement psuCorporateIdTypeAuthorisation;

    @FindBy(xpath = "(//*[@class='cell first-title'])[6]")
    private WebElement psuDeviceIdAuthorisation;

    @FindBy(xpath = "(//*[@class='cell type'])[6]")
    private WebElement psuDeviceIdTypeAuthorisation;

    @FindBy(xpath = "(//*[@class='cell first-title'])[7]")
    private WebElement psuUserAgentAuthorisation;

    @FindBy(xpath = "(//*[@class='cell type'])[7]")
    private WebElement psuUserAgentTypeAuthorisation;

    @FindBy(xpath = "(//*[@class='cell first-title'])[8]")
    private WebElement psuGeoLocationAuthorisation;

    @FindBy(xpath = "(//*[@class='cell type'])[8]")
    private WebElement psuGeoLocationTypeAuthorisation;

    @FindBy(xpath = "(//*[@class='cell first-title'])[9]")
    private WebElement psuIpAddressAuthorisation;

    @FindBy(xpath = "(//*[@class='cell type'])[9]")
    private WebElement psuIpAddressTypeAuthorisation;

    @FindBy(xpath = "(//*[@class='cell first-title'])[10]")
    private WebElement tppSignatureCertAuthorisation;

    @FindBy(xpath = "(//*[@class='cell type'])[10]")
    private WebElement tppSignatureCertTypeAuthorisation;

    @FindBy(xpath = "(//*[@class='cell first-title'])[11]")
    private WebElement signatureAuthorisation;

    @FindBy(xpath = "(//*[@class='cell type'])[11]")
    private WebElement signatureTypeAuthorisation;

    @FindBy(xpath = "(//*[@class='cell first-title'])[12]")
    private WebElement contentTypeAuthorisation;

    @FindBy(xpath = "(//*[@class='cell type'])[12]")
    private WebElement contentTypeTypeAuthorisation;

    @FindBy(xpath = "(//*[@class='response-button active'])[1]")
    private WebElement requestParameterAuthorisation;

    @FindBy(xpath = "(//*[@class='name-wrapper']//span)[1]")
    private WebElement providerCodeAuthorisation;

    @FindBy(xpath = "(//*[@class='param-row param-type']//span)[1]")
    private WebElement providerCodeTypeAuthorisation;

    @FindBy(xpath = "(//*[@class='name-wrapper']//span)[3]")
    private WebElement consentIdAuthorisation;

    @FindBy(xpath = "(//*[@class='param-row param-type']//span)[2]")
    private WebElement consentIdTypeAuthorisation;

    @FindBy(xpath = "(//*[@class='name-wrapper']//span)[5]")
    private WebElement authorisationId;

    @FindBy(xpath = "(//*[@class='param-row param-type']//span)[3]")
    private WebElement authorisationIdType;

    @FindBy(xpath = "(//*[@class='response-button active'])[1]")
    private WebElement responseAuthorisation;

    @FindBy(xpath = "(//*[@class='name-wrapper']//span)[7]")
    private WebElement scaStatusAuthorisation;

    @FindBy(xpath = "(//*[@class='param-row param-type']//span)[4]")
    private WebElement scaStatusTypeAuthorisation;

    @FindBy(xpath = "(//*[@class='error_response-button'])[1]")
    private WebElement errorResponseAuthorisation;

    @FindBy(xpath = "(//*[@class='name-wrapper']//span)[8]")
    private WebElement errorResponseTppMessageAuthorisation;

    @FindBy(xpath = "(//*[@class='param-row param-type']//span)[5]")
    private WebElement errorResponseTppMessageTypeAuthorisation;

    @FindBy(xpath = "(//*[@class='name-wrapper']//span)[9]")
    private WebElement errorResponseCategoryAuthorisation;

    @FindBy(xpath = "(//*[@class='param-row param-type']//span)[6]")
    private WebElement errorResponseCategoryTypeAuthorisation;

    @FindBy(xpath = "(//*[@class='name-wrapper']//span)[10]")
    private WebElement errorResponseCodeAuthorisation;

    @FindBy(xpath = "(//*[@class='param-row param-type']//span)[7]")
    private WebElement errorResponseCodeTypeAuthorisation;

    @FindBy(xpath = "(//*[@class='name-wrapper']//span)[11]")
    private WebElement errorResponseTextAuthorisation;

    @FindBy(xpath = "(//*[@class='param-row param-type']//span)[8]")
    private WebElement errorResponseTextTypeAuthorisation;

    public WebElement getEndpointAuthorisationName() {
        return endpointAuthorisationName;
    }

    public WebElement getEndpointAuthorisationMethod() {
        return endpointAuthorisationMethod;
    }

    public WebElement getEndpointAuthorisationUri() {
        return endpointAuthorisationUri;
    }

    public WebElement getHeadersAuthorisation() {
        return headersAuthorisation;
    }

    public WebElement getXRequestIdAuthorisation() {
        return xRequestIdAuthorisation;
    }

    public WebElement getXRequestIdTypeAuthorisation() {
        return xRequestIdTypeAuthorisation;
    }

    public WebElement getDigestAuthorisation() {
        return digestAuthorisation;
    }

    public WebElement getDigestTypeAuthorisation() {
        return digestTypeAuthorisation;
    }

    public WebElement getDateAuthorisation() {
        return dateAuthorisation;
    }

    public WebElement getDateTypeAuthorisation() {
        return dateTypeAuthorisation;
    }

    public WebElement getPsuIdAuthorisation() {
        return psuIdAuthorisation;
    }

    public WebElement getPsuIdTypeAuthorisation() {
        return psuIdTypeAuthorisation;
    }

    public WebElement getPsuCorporateIdAuthorisation() {
        return psuCorporateIdAuthorisation;
    }

    public WebElement getPsuCorporateIdTypeAuthorisation() {
        return psuCorporateIdTypeAuthorisation;
    }

    public WebElement getPsuDeviceIdAuthorisation() {
        return psuDeviceIdAuthorisation;
    }

    public WebElement getPsuDeviceIdTypeAuthorisation() {
        return psuDeviceIdTypeAuthorisation;
    }

    public WebElement getPsuUserAgentAuthorisation() {
        return psuUserAgentAuthorisation;
    }

    public WebElement getPsuUserAgentTypeAuthorisation() {
        return psuUserAgentTypeAuthorisation;
    }

    public WebElement getPsuGeoLocationAuthorisation() {
        return psuGeoLocationAuthorisation;
    }

    public WebElement getPsuGeoLocationTypeAuthorisation() {
        return psuGeoLocationTypeAuthorisation;
    }

    public WebElement getPsuIpAddressAuthorisation() {
        return psuIpAddressAuthorisation;
    }

    public WebElement getPsuIpAddressTypeAuthorisation() {
        return psuIpAddressTypeAuthorisation;
    }

    public WebElement getTppSignatureCertAuthorisation() {
        return tppSignatureCertAuthorisation;
    }

    public WebElement getTppSignatureCertTypeAuthorisation() {
        return tppSignatureCertTypeAuthorisation;
    }

    public WebElement getSignatureAuthorisation() {
        return signatureAuthorisation;
    }

    public WebElement getSignatureTypeAuthorisation() {
        return signatureTypeAuthorisation;
    }

    public WebElement getContentTypeAuthorisation() {
        return contentTypeAuthorisation;
    }

    public WebElement getContentTypeTypeAuthorisation() {
        return contentTypeTypeAuthorisation;
    }

    public WebElement getRequestParameterAuthorisation() {
        return requestParameterAuthorisation;
    }

    public WebElement getProviderCodeAuthorisation() {
        return providerCodeAuthorisation;
    }

    public WebElement getProviderCodeTypeAuthorisation() {
        return providerCodeTypeAuthorisation;
    }

    public WebElement getConsentIdAuthorisation() {
        return consentIdAuthorisation;
    }

    public WebElement getConsentIdTypeAuthorisation() {
        return consentIdTypeAuthorisation;
    }

    public WebElement getAuthorisationId() {
        return authorisationId;
    }

    public WebElement getAuthorisationIdType() {
        return authorisationIdType;
    }

    public WebElement getResponseAuthorisation() {
        return responseAuthorisation;
    }

    public WebElement getScaStatusAuthorisation() {
        return scaStatusAuthorisation;
    }

    public WebElement getScaStatusTypeAuthorisation() {
        return scaStatusTypeAuthorisation;
    }

    public WebElement getErrorResponseAuthorisation() {
        return errorResponseAuthorisation;
    }

    public WebElement getErrorResponseTppMessageAuthorisation() {
        return errorResponseTppMessageAuthorisation;
    }

    public WebElement getErrorResponseTppMessageTypeAuthorisation() {
        return errorResponseTppMessageTypeAuthorisation;
    }

    public WebElement getErrorResponseCategoryAuthorisation() {
        return errorResponseCategoryAuthorisation;
    }

    public WebElement getErrorResponseCategoryTypeAuthorisation() {
        return errorResponseCategoryTypeAuthorisation;
    }

    public WebElement getErrorResponseCodeAuthorisation() {
        return errorResponseCodeAuthorisation;
    }

    public WebElement getErrorResponseCodeTypeAuthorisation() {
        return errorResponseCodeTypeAuthorisation;
    }

    public WebElement getErrorResponseTextAuthorisation() {
        return errorResponseTextAuthorisation;
    }

    public WebElement getErrorResponseTextTypeAuthorisation() {
        return errorResponseTextTypeAuthorisation;
    }
}
