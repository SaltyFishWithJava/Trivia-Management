/*

 */

describe('admin game tset', function () {

    let GAME_ID = '2'
    let GAME_PLAYER = 'tt1'

    it('should assert that <title> is correct', function () {
        cy.visit('http://localhost:8080/adminGame.jsp')
        cy.title().should('include', '游戏记录管理')
    });

    context('before search page init', function () {

        it('should search input exist', function () {
            cy.get('#gameId').should('exist')
            cy.get('#playerName').should('exist')
        });

        it('should reset correctly', function () {
            cy.get('#gameId').type(GAME_ID)
            cy.get('#playerName').type(GAME_PLAYER)
            cy.get(':reset').click()
            cy.get('#gameId').should('have.value','')
            cy.get('#playerName').should('have.value','')
        });

        it('should search input empty', function () {
            cy.get('#gameId').should('have.value', '')
            cy.get('#playerName').should('have.value', '')
        });

        it('should search result not empty', function () {
            cy.get('#gameResNum').should('not.have.text', '0')
        });
    })

    context('search game info successfully', function () {
        beforeEach(function () {
            cy.visit('http://localhost:8080/adminGame.jsp')
        })

        it('should search game info successfully -- by game id', function () {
            cy.get('#gameId').type(GAME_ID)
            cy.get('#gameSearchBtn').click()
            cy.get('#gameResNum').should('have.text', '1')
            cy.get('#ordersTable td').first().should('contain', GAME_ID)
        });

        it('should search game info successfully -- by game player', function () {
            cy.get('#playerName').type(GAME_PLAYER)
            cy.get('#gameSearchBtn').click()
            cy.get('#gameResNum').should('not.have.text', '0')
            cy.get('#ordersTable td').should('contain', GAME_PLAYER)
        });

        it('should search game info successfully -- by both', function () {
            cy.get('#gameId').type(GAME_ID)
            cy.get('#playerName').type(GAME_PLAYER)
            cy.get('#gameSearchBtn').click()
            cy.get('#gameResNum').should('have.text', '1')
            cy.get('#ordersTable td').first().should('contain', GAME_ID)
            cy.get('#ordersTable td').should('contain', GAME_PLAYER)
        });

    })

})