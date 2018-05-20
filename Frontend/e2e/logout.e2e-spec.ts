/*import { browser, by, element } from 'protractor';
import { getPath } from './getpath';
import { protractor } from 'protractor/built/ptor';

describe('Logout functionality', () => {
    var EC = protractor.ExpectedConditions;
    var logoutBtn = element(by.buttonText('Logout'));

    beforeEach(() => {
        browser.get('/recipes');
    })

    it('should log out', () => {
        browser.wait(EC.visibilityOf(logoutBtn), 5000);
        logoutBtn.click();

        expect(getPath()).toEqual('/recipes');
    });
})*/