import { browser, by, element } from 'protractor';
import { getPath } from './getpath';
import { protractor } from 'protractor/built/ptor';

describe('Login functionality', () => {
    var EC = protractor.ExpectedConditions;
    var loginBtn = element(by.buttonText('Login'));
    var loginUsrName = element(by.css('input[id="usernameLoginInput"]'));
    
    beforeEach(() => {
        
        browser.get('/recipes');
        
        browser.wait(EC.visibilityOf(loginBtn), 5000);
        loginBtn.click();
    })

    it('should fail to log in for invalid credentials', () => {
        browser.wait(EC.visibilityOf(loginUsrName), 5000);
        loginUsrName.sendKeys('sdatuéliu@aslédkj.laskdjg');

        element(by.css('input[id="passwordLoginInput"]')).sendKeys('eiutzlkjsdzgl');
        element(by.id('loginBtn')).click();
        expect(browser.wait(EC.textToBePresentInElement
            (element(by.id('loginErr')), 'Wrong'), 5000));
    });

    it('should log in for valid credentials', () => {
        
        browser.wait(EC.visibilityOf(loginUsrName), 5000);
        loginUsrName.sendKeys('Felhaszn');

        element(by.css('input[id="passwordLoginInput"]')).sendKeys('Almafa1');
        element(by.id('loginBtn')).click();
        expect(getPath()).toEqual('/recipes');
    })
})