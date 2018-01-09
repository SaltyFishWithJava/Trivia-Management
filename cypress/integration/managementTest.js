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

    })

    context('delete question test', function () {
        beforeEach(function () {
            cy.visit('http://localhost:8080/adminQues.jsp')
        })

        it('should allow me to delete question', function () {
            cy.get('#quesText').type(MDF_QUES_CONTENT)
            cy.get('#quesSearchBtn').click()
            cy.get('#ordersTable button').last().click()
            cy.get('#ordersTable td').first().should('not.exist')
        });

        it('should delete question successfully', function () {
            cy.get('#quesText').type(MDF_QUES_CONTENT)
            cy.get('#quesSearchBtn').click()
            cy.get('#quesResultNum').should('have.text', '0')
        });
    })

})


/*

 */

describe('admin game test', function () {

    let GAME_ID = '2'
    let ILLEGAL_GAME_ID = 'LUANMA'
    let GAME_PLAYER = 'tt1'
    let GAME_PLAYER_NOT_EXIST = 'tt5'

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
            cy.get('#gameId').should('have.value', '')
            cy.get('#playerName').should('have.value', '')
        });

        it('should search input empty', function () {
            cy.get('#gameId').should('have.value', '')
            cy.get('#playerName').should('have.value', '')
        });

        it('should search result not empty', function () {
            cy.get('#gameResNum').should('not.have.text', '0')
        });
    })

    context('search game info test', function () {
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

        it('should search game info -- not exist game player', function () {
            cy.get('#playerName').type(GAME_PLAYER_NOT_EXIST)
            cy.get('#gameSearchBtn').click()
            cy.get('#gameResNum').should('have.text', '0')
            cy.get('#ordersTable td').should('not.exist')
        });

        it('should search game info -- illegal game id', function () {
            cy.get('#gameId').type(ILLEGAL_GAME_ID)
            cy.get('#gameSearchBtn').click()
            cy.get('#gameResNum').should('not.have.text', '0')
        });

        it('should search game info -- illegal game id && not exist game player', function () {
            cy.get('#gameId').type(ILLEGAL_GAME_ID)
            cy.get('#playerName').type(GAME_PLAYER_NOT_EXIST)
            cy.get('#gameSearchBtn').click()
            cy.get('#gameResNum').should('have.text', '0')
            cy.get('#ordersTable td').should('not.exist')
        });
    })

})


/*

 */

describe('admin user tset', function () {

    let SEARCH_USERNAME_EXIST = 'test1'
    let SEARCH_USERNAME_NOT_EXIST = 'cyjzai'
    let MDF_PASSWORD = '123456'

    it('should assert that <title> is correct', function () {
        cy.visit('http://localhost:8080/adminUser.jsp')
        cy.title().should('include', '用户管理')
    });

    context('before search page init', function () {

        it('should search input exist', function () {
            cy.get('#userName').should('exist')
            cy.get('#userStatus').should('exist')
        });

        it('should reset correctly', function () {
            cy.get('#userName').type(SEARCH_USERNAME_EXIST)
            cy.get('#reset').click()
            cy.get('#userName').should('have.value', '')
        });
    })

    context('searching test', function () {

        beforeEach(function () {
            cy.visit('http://localhost:8080/adminUser.jsp')
        })

        it('should search by exist username success', function () {
            cy.get('#userName').type(SEARCH_USERNAME_EXIST)
            cy.get('#search').click()
            cy.get('#resultNum').should('have.text', '1')
            cy.get('#ordersTable td').first().should('have.text', SEARCH_USERNAME_EXIST)
        });

        it('should search null by incorrect username', function () {
            cy.get('#userName').type(SEARCH_USERNAME_NOT_EXIST)
            cy.get('#search').click()
            cy.get('#resultNum').should('have.text', '0')
            cy.get('#ordersTable td').should('not.exist')
        });
    })

    context('admin user test', function () {
        beforeEach(function () {
            cy.visit('http://localhost:8080/adminUser.jsp')
        })

        it('should change user status correctly -- activate', function () {
            cy.get('#userName').type(SEARCH_USERNAME_EXIST)
            cy.get('#search').click()
            cy.get('#ordersTable tbody').first().find('button').first().next().click()
            cy.get('#userName').type(SEARCH_USERNAME_EXIST)
            cy.get('#search').click()
            cy.get('#ordersTable td').eq(3).find('span').should('have.text', '已激活')
        });

        it('should change user status correctly -- frozen', function () {
            cy.get('#userName').type(SEARCH_USERNAME_EXIST)
            cy.get('#search').click()
            cy.get('#ordersTable tbody').first().find('button').last().click()
            cy.get('#userName').type(SEARCH_USERNAME_EXIST)
            cy.get('#search').click()
            cy.get('#ordersTable td').eq(3).find('span').should('have.text', '已冻结')
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
            cy.get('#modalUserPsw').should('have.value', MDF_PASSWORD)
        });

        it('should change user info correctly', function () {
            cy.get('#userName').type(SEARCH_USERNAME_EXIST)
            cy.get('#search').click()
            cy.get('#ordersTable tbody').first().find('button').first().click()
            cy.get('#modalUserPsw').clear()
            cy.get('#modalUserPsw').type(MDF_PASSWORD)
            cy.get('#modalConfirm').click()
            cy.get('#ordersTable td').eq(1).should('have.text', MDF_PASSWORD)
            cy.get('#userName').type(SEARCH_USERNAME_EXIST)
            cy.get('#search').click()
            cy.get('#ordersTable td').eq(1).should('have.text', MDF_PASSWORD)
        });
    })
})