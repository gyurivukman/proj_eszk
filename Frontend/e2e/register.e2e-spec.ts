import { browser, by, element } from 'protractor';
import { getPath } from './getpath';
import { protractor } from 'protractor/built/ptor';

describe('Registration functionality', () => {
    beforeEach(() => {
        browser.get('/recipes');
        var EC = protractor.ExpectedConditions;
        var registerBtnId = element(by.id('registerBtnId'));
        browser.wait(EC.visibilityOf(registerBtnId), 5000);
        registerBtnId.click();
    })

    /*it('should fail to register because of invalid password', () => {
        element(by.css('input[type="text"]')).sendKeys('Abc');
        element(by.css('input[type="text"]')).sendKeys('Abc');
        element(by.css('input[type="text"]')).sendKeys('Username');
        element(by.css('input[type="password"]')).sendKeys('a');
        element(by.css('input[type="email"]')).sendKeys('user@host.com');
        expect( element('input[name="tos"]').attr('checked') ).toBeTruthy();
        element(by.css('input[type="button"]')).click();
        expect(getPath()).toEqual('/login');
    });*/

    it('should register with these', () => {
        element(by.css('input[name="firstName"]')).sendKeys('Abcd');
        element(by.css('input[name="lastName"]')).sendKeys('Abcd');
        element(by.css('input[name="username"]')).sendKeys('Felh');
        element(by.css('input[type="password"]')).sendKeys('Almafa1');
        element(by.css('input[type="email"]')).sendKeys('user@hostt.com');
        element(by.css('input[id="acceptTerms"]')).click();
        element(by.buttonText('Sign up!')).click();
        expect(getPath()).toEqual('/recipes');
    })
})