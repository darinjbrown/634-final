// jest.config.js
module.exports = {
    testEnvironment: 'jsdom',
    transform: {
        "^.+\\.(js|jsx)$": "babel-jest"
    },
    moduleNameMapper: {
        "\\.(css|less|scss|sass)$": "<rootDir>/src/mocks/styleMock.js",
        "\\.(jpg|jpeg|png|gif|webp|svg)$": "<rootDir>/src/mocks/fileMock.js"
    },
    setupFilesAfterEnv: ['<rootDir>/src/setupTests.js'],
    transformIgnorePatterns: [
        "/node_modules/(?!axios)/"
    ]
};