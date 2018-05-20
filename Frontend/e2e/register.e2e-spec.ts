import { browser, by, element } from 'protractor';
import { getPath } from './getpath';
import { protractor } from 'protractor/built/ptor';

describe('Registration functionality', () => {
    var EC = protractor.ExpectedConditions;
    var firstName = element(by.css('input[name="firstName"]'));

    beforeEach(() => {
        browser.get('/recipes');

        var registerBtnId = element(by.id('registerBtnId'));
        browser.wait(EC.visibilityOf(registerBtnId), 5000);
        registerBtnId.click();

        browser.wait(EC.visibilityOf(firstName), 5000);
    })

    it('should register with these', () => {
        firstName.sendKeys('Abcd');
        element(by.css('input[name="lastName"]')).sendKeys('Abcde');
        element(by.css('input[name="username"]')).sendKeys('Felhaszn');
        element(by.css('input[name="password"]')).sendKeys('Almafa1');
        element(by.css('input[type="email"]')).sendKeys('user@hostt.com');
        element(by.css('input[id="acceptTerms"]')).click();
        element(by.buttonText('Sign up!')).click();
        expect(getPath()).toEqual('/recipes');
    })

    it('should fail to register because of first name / last name', () => {
        firstName.sendKeys('1');
        element(by.css('input[name="lastName"]')).sendKeys('1');
        element(by.css('input[name="username"]')).sendKeys('a');
        element(by.css('input[name="password"]')).sendKeys('Almafa1');
        element(by.css('input[type="email"]')).sendKeys('user@host.com');
        element(by.css('input[id="acceptTerms"]')).click();
        element(by.buttonText('Sign up!')).click();

        /*expect(browser.wait(EC.textToBePresentInElement
            (element(by.id('firstNameError')), 'First name'), 5000));*/
    });

    it('should fail to register because of username', () => {
        firstName.sendKeys('Abcd');
        element(by.css('input[name="lastName"]')).sendKeys('Abcd');
        element(by.css('input[name="username"]')).sendKeys('x');
        element(by.css('input[type="password"]')).sendKeys('Almafa1');
        element(by.css('input[type="email"]')).sendKeys('user@host.com');
        element(by.css('input[id="acceptTerms"]')).click();
        element(by.buttonText('Sign up!')).click();

        /*expect(browser.wait(EC.textToBePresentInElement
            (element(by.id('usernameError')), 'Username'), 5000));*/
    });

})