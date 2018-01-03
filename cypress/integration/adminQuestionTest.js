/*

 */

describe('admin question tset', function () {

    let QUES_CONTENT = 'TEST TEST TEST TEST TEST'
    let MDF_QUES_CONTENT = 'QAQ QAQ QAQ QAQ QAQ'
    let QUES_SELECT_A = 'testA'
    let QUES_SELECT_B = 'testB'
    let QUES_SELECT_C = 'testC'
    let QUES_SELECT_D = 'testD'

    it('should assert that <title> is correct', function () {
        cy.visit('http://localhost:8080/adminQues.jsp')
        cy.title().should('include', '题目管理')
    });

    context('before search page init', function () {

        it('should search input exist', function () {
            cy.get('#quesText').should('exist')
            cy.get('.sbSelector').should('exist')
        });

        it('should search input empty', function () {
            cy.get('#quesText').should('have.value', '')
        });

        it('should search result not empty', function () {
            cy.get('#quesResultNum').should('not.have.text', '0')
        });
    })

    context('add question btn test', function () {

        beforeEach(function () {
            cy.visit('http://localhost:8080/adminQues.jsp')
        })

        it('should upload add question', function () {
            cy.get('#addQuesBtn').click()
            cy.location().should(function (location) {
                expect(location.hostname).to.eq('localhost')
                expect(location.href).to.eq('http://localhost:8080/quesDetail.jsp')
                // expect(location.origin).to.eq('http://localhost:8000')
                // expect(location.pathname).to.eq('/quesDetail.jsp')
            })
        });
    })

    context('add question test', function () {

        beforeEach(function () {
            cy.visit('http://localhost:8080/quesDetail.jsp')
        })

        it('before add page init', function () {
            cy.get('#questionContent').should('exist')
            cy.get('#questionSelect_A').should('exist')
            cy.get('#questionSelect_B').should('exist')
            cy.get('#questionSelect_C').should('exist')
            cy.get('#questionSelect_D').should('exist')
            cy.get('.btn-submit').should('exist')
            cy.get('.sbSelector').should('exist')
        });

        it('should allow me to add question', function () {
            cy.get('#questionContent').type(QUES_CONTENT)
            cy.get('#questionSelect_A').type(QUES_SELECT_A)
            cy.get('#questionSelect_B').type(QUES_SELECT_B)
            cy.get('#questionSelect_C').type(QUES_SELECT_C)
            cy.get('#questionSelect_D').type(QUES_SELECT_D)
            cy.get('.btn-submit').click()
        });
    })

    context('add question result test', function () {
        beforeEach(function () {
            cy.visit('http://localhost:8080/adminQues.jsp')
        })

        it('should search question added successfully', function () {
            cy.get('#quesText').type(QUES_CONTENT)
            cy.get('#quesSearchBtn').click()
            cy.get('#quesResultNum').should('have.text', '1')
            cy.get('#ordersTable td').first().should('contain', QUES_CONTENT)
            cy.get('#ordersTable td.ques-ans').should('contain', 'A')
            cy.get('#ordersTable td.ques-type').should('contain', '生活常识类')
        });
    })

    context('mdf question test', function () {
        beforeEach(function () {
            cy.visit('http://localhost:8080/adminQues.jsp')
        })

        it('should upload mdf question', function () {
            cy.get('#quesText').type(QUES_CONTENT)
            cy.get('#quesSearchBtn').click()
            cy.get('#ordersTable button').first().click()
            //跳转至修改题目页面
            cy.get('#questionContent').should('have.value', QUES_CONTENT)
            cy.get('#questionSelect_A').should('have.value', QUES_SELECT_A)
            cy.get('#questionSelect_B').should('have.value', QUES_SELECT_B)
            cy.get('#questionSelect_C').should('have.value', QUES_SELECT_C)
            cy.get('#questionSelect_D').should('have.value', QUES_SELECT_D)
            cy.get('.btn-submit').should('exist')
            cy.get('.sbSelector').should('exist')
        });

        it('should allow me mdf question', function () {
            cy.get('#quesText').type(QUES_CONTENT)
            cy.get('#quesSearchBtn').click()
            cy.get('#ordersTable button').first().click()
            //跳转至修改题目页面
            cy.get('#questionContent').clear()
            cy.get('#questionContent').type(MDF_QUES_CONTENT)
            cy.get('.btn-submit').click()
        });

        it('should mdf successfully', function () {
            cy.get('#quesText').type(MDF_QUES_CONTENT)
            cy.get('#quesSearchBtn').click()
            cy.get('#quesResultNum').should('have.text', '1')
            cy.get('#ordersTable td').first().should('contain', MDF_QUES_CONTENT)
        });

        it('should allow me mdf question back', function () {
            cy.get('#quesText').type(MDF_QUES_CONTENT)
            cy.get('#quesSearchBtn').click()
            cy.get('#ordersTable button').first().click()
            //跳转至修改题目页面
            cy.get('#questionContent').clear()
            cy.get('#questionContent').type(QUES_CONTENT)
            cy.get('.btn-submit').click()
        });

        it('should mdf successfully', function () {
            cy.get('#quesText').type(QUES_CONTENT)
            cy.get('#quesSearchBtn').click()
            cy.get('#quesResultNum').should('have.text', '1')
            cy.get('#ordersTable td').first().should('contain', QUES_CONTENT)
        });
    })
    
    context('delete question test',function () {
        beforeEach(function () {
            cy.visit('http://localhost:8080/adminQues.jsp')
        })

        it('should allow me to delete question', function () {
            cy.get('#quesText').type(QUES_CONTENT)
            cy.get('#quesSearchBtn').click()
            cy.get('#ordersTable button').last().click()
            cy.get('#ordersTable td').first().should('not.exist')
        });

        it('should delete question successfully', function () {
            cy.get('#quesText').type(QUES_CONTENT)
            cy.get('#quesSearchBtn').click()
            cy.get('#ordersTable td').should('not.exist')
        });
    })

})