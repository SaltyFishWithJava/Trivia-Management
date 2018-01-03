/*

 */

describe('admin user tset',function () {

    let SEARCH_USERNAME_EXIST = 'test1'
    let SEARCH_USERNAME_NOT_EXIST = 'cyjzai'
    let MDF_PASSWORD = '123456'

    it('should assert that <title> is correct', function () {
        cy.visit('http://localhost:8080/adminUser.jsp')
        cy.title().should('include','用户管理')
    });

    context('before search page init',function () {

        it('should search input exist', function () {
            cy.get('#userName').should('exist')
            cy.get('#userStatus').should('exist')
        });

        it('should reset correctly', function () {
            cy.get('#userName').type(SEARCH_USERNAME_EXIST)
            cy.get('#reset').click()
        });
    })

    context('searching test',function () {

        beforeEach(function () {
            cy.visit('http://localhost:8080/adminUser.jsp')
        })

        it('should search by exist username success', function () {
            cy.get('#userName').type(SEARCH_USERNAME_EXIST)
            cy.get('#search').click()
            cy.get('#resultNum').should('have.text','1')
            cy.get('#ordersTable td').first().should('have.text',SEARCH_USERNAME_EXIST)
        });

        it('should search null by incorrect username', function () {
            cy.get('#userName').type(SEARCH_USERNAME_NOT_EXIST)
            cy.get('#search').click()
            cy.get('#resultNum').should('have.text','0')
            cy.get('#ordersTable td').should('not.exist')
        });
    })
    
    context('admin user test',function () {
        beforeEach(function () {
            cy.visit('http://localhost:8080/adminUser.jsp')
        })

        it('should change user status correctly -- activate', function () {
            cy.get('#userName').type(SEARCH_USERNAME_EXIST)
            cy.get('#search').click()
            cy.get('#ordersTable tbody').first().find('button').first().next().click()
            cy.get('#userName').type(SEARCH_USERNAME_EXIST)
            cy.get('#search').click()
            cy.get('#ordersTable td').eq(3).find('span').should('have.text','已激活')
        });

        it('should change user status correctly -- frozen', function () {
            cy.get('#userName').type(SEARCH_USERNAME_EXIST)
            cy.get('#search').click()
            cy.get('#ordersTable tbody').first().find('button').last().click()
            cy.get('#userName').type(SEARCH_USERNAME_EXIST)
            cy.get('#search').click()
            cy.get('#ordersTable td').eq(3).find('span').should('have.text','已冻结')
        });

        it('should reset user info correctly', function () {
            cy.get('#userName').type(SEARCH_USERNAME_EXIST)
            cy.get('#search').click()
            cy.get('#ordersTable tbody').first().find('button').first().click()
            // var originPassword = cy.get('#modalUserPsw').val();  //????????????
            // var originPassword = Cypress.$('#modalUserPsw').get(0)
            // console.log(originPassword)
            cy.get('#modalUserPsw').clear()
            cy.get('#modalUserPsw').type(MDF_PASSWORD)
            cy.get('#modalReset').click()
            cy.get('#modalUserPsw').should('have.value',MDF_PASSWORD)
        });

        it('should change user info correctly', function () {
            cy.get('#userName').type(SEARCH_USERNAME_EXIST)
            cy.get('#search').click()
            cy.get('#ordersTable tbody').first().find('button').first().click()
            cy.get('#modalUserPsw').clear()
            cy.get('#modalUserPsw').type(MDF_PASSWORD)
            cy.get('#modalConfirm').click()
            cy.get('#ordersTable td').eq(1).should('have.text',MDF_PASSWORD)
            cy.get('#userName').type(SEARCH_USERNAME_EXIST)
            cy.get('#search').click()
            cy.get('#ordersTable td').eq(1).should('have.text',MDF_PASSWORD)
        });
    })
})