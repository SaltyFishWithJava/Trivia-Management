/*

 */

describe('admin user tset',function () {

    let SEARCH_USERNAME = 't'

    it('should assert that <title> is correct', function () {
        cy.visit('http://localhost:8080/adminUser.jsp')
        cy.title().should('include','用户管理')
    });

    context('before search page init',function () {
        beforeEach(function () {
            cy.visit('http://localhost:8080/adminUser.jsp')
        })

        it('should search input exist', function () {
            cy.get('#userName').should('exist')
            cy.get('#userStatus').should('exist')
        });

        it('should search by username success', function () {
            cy.get('#userName').type(SEARCH_USERNAME)
            cy.get('#search').click()
            cy.get('#resultNum').should('have.text','1')
            cy.get('#ordersTable td').first().should('have.text',SEARCH_USERNAME)

        });

    })
})