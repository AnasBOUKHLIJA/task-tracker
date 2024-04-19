'use client'

import { title } from "@/components/primitives";
import { TaskService } from "@/services/TaskService";
import { Accordion, AccordionItem, Avatar, Button, Chip, getKeyValue } from "@nextui-org/react";
import { useEffect, useState } from "react";
import { siteConfig } from "@/config/site";
import { BugTask } from "@/models/BugTask";


export default function BugTasksPage() {

	const [bugTasks, setBugTasks] = useState<BugTask[]>([]);
	const [indice, setIndice] = useState(0);
	useEffect(() => {
		TaskService.getAllBugTasks().then((response) => {
			setBugTasks(response);
		});
	}, [indice]);

	const handleDelete = (id: number) => {
		TaskService.deleteTask(id).catch((error) => {
			console.error("Error deleting bug task:", error);
		});
		setIndice((prevIndice) => prevIndice + 1);
	};


	return (
		<div>
			<h1 className={`${title()} py-5`}>Bug Tasks</h1>
			{bugTasks.length > 0 ? (
				<Accordion variant="splitted" disabledKeys={["2"]}>
					{bugTasks.map((bugTask) => (
						<AccordionItem
							key={bugTask.id}
							startContent={
								<Avatar
									className="bg-transparent"
									radius="md"
									src="/assets/bug.svg"
								/>
							}
							aria-label={bugTask.name}
							subtitle={<Chip variant="flat" color={getKeyValue(siteConfig.status, bugTask.status).color}> {getKeyValue(siteConfig.status, bugTask.status).name} </Chip>}
							title={
								<div className="flex justify-between items-center">
									<h1>{bugTask.name}</h1>
									<Avatar
										className="bg-transparent"
										radius="sm"
										src={getKeyValue(siteConfig.severities, bugTask.severity).icon}
									/>
								</div>
							}
						>

							<div>
								<h1 className="font-bold text-2xl">{bugTask.name}</h1>
								<p>{bugTask.description}</p>
								<p>Steps to reprodure the bug : {bugTask.stepsToReproduce}</p>
								<small>{bugTask.createdAt && 'Created at ' + bugTask.createdAt.toLocaleString()}</small>
							</div>

							<div className="flex justify-end items-center gap-2">
								<Button onClick={() => handleDelete(bugTask.id)} className="text-tiny" variant="flat" color="danger" radius="lg" size="sm">
									delete
								</Button>
								<Button className="text-tiny" variant="flat" color="default" radius="lg" size="sm">
									Open task
								</Button>
							</div>
						</AccordionItem>
					))}
				</Accordion>
			) : (
				<p>No bug tasks available</p>
			)}
		</div>
	);
}