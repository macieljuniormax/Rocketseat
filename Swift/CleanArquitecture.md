ProjectRoot/
├── App
│ ├── AppDelegate.swift
│ ├── SceneDelegate.swift
│ └── ReminderFlowController.swift
│
├── Core
│ ├── Protocols
│ │ ├── AppErrorProtocol.swift
│ │ └── LoggerProtocol.swift
│ ├── Utilities
│ │ └── String+Ext.swift
│ │ └── DateUtils.swift // Exemplo: Funções para manipulação de datas
│ │ └── Extensions.swift // Onde você pode agrupar várias extensões genéricas
│ ├── DesignSystem
│ │ ├── Colors
│ │ │ └── Colors.swift
│ │ ├── Metrics
│ │ │ └── Metrics.swift
│ │ ├── Typographies
│ │ │ └── Typographies.swift
│ │ └── Components // Para componentes de UI agnósticos
│ │ └── CommonButton.swift
│ │ └── CustomTableViewCell.swift
│ │ └── CommonUIExtensions.swift // Extensões específicas de UIKit/SwiftUI que são genéricas no projeto
│ └── SharedModels.swift // Se você tiver alguns modelos muito genéricos que não são entidades de domínio
│
├── Domain
│ ├── Entities
│ │ ├── User.swift
│ │ └── Reminder.swift
│ │ └── AuthenticationCredentials.swift // Ex: struct para login/registro
│ ├── UseCases
│ │ ├── Protocols
│ │ │ ├── LoginUseCaseProtocol.swift
│ │ │ ├── FetchRemindersUseCaseProtocol.swift
│ │ │ └── SaveUserSessionUseCaseProtocol.swift
│ │ ├── Implementations
│ │ │ ├── LoginUseCase.swift
│ │ │ ├── FetchRemindersUseCase.swift
│ │ │ └── SaveUserSessionUseCase.swift
│ └── Repositories
│ ├── AuthRepositoryProtocol.swift
│ └── RemindersRepositoryProtocol.swift
│ └── AppSettingsRepositoryProtocol.swift // Protocolo para UserDefaults/Keychain
│
├── Data
│ ├── Repositories
│ │ ├── Firebase
│ │ │ └── FirebaseAuthRepository.swift
│ │ ├── Local
│ │ │ ├── UserDefaultsAuthRepository.swift
│ │ │ └── CoreDataRemindersRepository.swift
│ │ └── Mappers // Mappers globais de Repositório (se não forem por Feature)
│ │ └── UserDataMapper.swift
│ │ └── ReminderDataMapper.swift
│ ├── Services
│ │ ├── Network
│ │ │ ├── APIClient.swift
│ │ │ ├── Endpoints.swift
│ │ │ └── DTOs // Data Transfer Objects
│ │ │ ├── LoginDTO.swift
│ │ │ └── UserResponseDTO.swift
│ │ │ └── ReminderResponseDTO.swift
│ │ └── Persistence
│ │ ├── UserDefaultsManager.swift
│ │ └── KeychainManager.swift
│ │ └── CoreDataStack.swift // Arquivo da pilha Core Data
│ └── // Remover a pasta 'Mappers' daqui se já estiver em Data/Repositories/Mappers
│
├── Features
│ ├── Login
│ │ ├── Presentation
│ │ │ ├── LoginViewController.swift
│ │ │ ├── LoginView.swift
│ │ │ └── LoginViewModel.swift
│ │ └── Coordinator
│ │ ├── LoginCoordinator.swift
│ │ └── LoginFlowDelegate.swift
│ ├── Splash
│ │ ├── Presentation
│ │ │ ├── SplashView.swift
│ │ │ ├── SplashViewController.swift
│ │ │ └── SplashViewModel.swift
│ │ └── Coordinator
│ │ ├── SplashCoordinator.swift
│ │ └── SplashFlowDelegate.swift
│ ├── Home
│ │ ├── Presentation
│ │ │ ├── HomeView.swift
│ │ │ ├── HomeViewController.swift
│ │ │ └── HomeViewModel.swift
│ │ └── Coordinator
│ │ ├── HomeCoordinator.swift
│ │ └── HomeFlowDelegate.swift
│ ├── ReminderDetails // Exemplo de outra Feature
│ │ ├── Presentation
│ │ │ ├── ReminderDetailsViewController.swift
│ │ │ ├── ReminderDetailsView.swift
│ │ │ └── ReminderDetailsViewModel.swift
│ │ └── Coordinator
│ │ ├── ReminderDetailsCoordinator.swift
│ │ └── ReminderDetailsFlowDelegate.swift
│
├── DependencyInjection
│ ├── ViewControllersFactory
│ │ ├── ViewControllersFactoryProtocol.swift
│ │ └── ViewControllersFactory.swift
│ ├── Containers
│ │ ├── AppContainer.swift // Contêiner principal que monta todas as dependências
│ │ ├── DataContainer.swift // Módulo para injeção de dependências da camada Data
│ │ └── DomainContainer.swift // Módulo para injeção de dependências da camada Domain (UseCases)
│ ├── Factories // Outras fábricas de objetos complexos (ex: UseCaseFactory, ServiceFactory)
│ │ └── UseCaseFactory.swift
│ │ └── RepositoryFactory.swift
│ └── Injected.swift // Exemplo: Para um wrapper @Injected property
│
└── Resources
├── Assets.xcassets
└── Localizable.strings
└── Info.plist
└── LaunchScreen.storyboard
